package com.pruebas_varios.service;

import com.pruebas_varios.domain.Factura;
import com.pruebas_varios.domain.Item;
import com.pruebas_varios.domain.Usuario;
import com.pruebas_varios.domain.Venta;
import com.pruebas_varios.repository.FacturaRepository;
import com.pruebas_varios.repository.ProductoRepository;
import com.pruebas_varios.repository.UsuarioRepository;
import com.pruebas_varios.repository.VentaRepository;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    //Se utiliza una variable de session para guardar una lista
    @Autowired
    private HttpSession session;

    //El siguiente método crea un item en la variable de session
    //Si la variable no existe se crea
    public void save(Item item) {
        //se recupera la variable session
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");

        //Se valida si la lista ya estaba como variable de session
        if (lista == null) {
            lista = new ArrayList<>();
        }

        boolean existe = false;
        for (Item i : lista) {
            if (Objects.equals(item.getIdProducto(), i.getIdProducto())) {
                existe = true;
                if (i.getCantidad() < i.getExistencias()) {
                    i.setCantidad(i.getCantidad() + 1);
                }
                break;
            }
        }
        if (!existe) { //Si no estaba en la lista se crea en ella...
            item.setCantidad(1);
            lista.add(item);
        }
        session.setAttribute("listaItems", lista);
    }

    //El siguiente método recupera un item de la variable de session
    //Si no está, retorna null
    public Item getItem(Item item) {
        //Se recupera la variable de session
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");
        //Si la lista no esta como variable de session, no hay items
        if (lista == null) {
            return null;
        }

        //Se busca si el idProducto ya está en la lista...
        for (Item i : lista) {
            if (Objects.equals(item.getIdProducto(), i.getIdProducto())) {
                return i;
            }
        }
        return null;
    }

    //El siguiente método recupera el totalde compra según la lista
    public double getTotal() {
        //Se recupera la variable de session
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");
        //Si la lista no esta como variable de session, total es 0
        if (lista == null) {
            return 0;
        }

        //Se busca si el idProducto ya está en la lista...
        double total = 0;
        for (Item i : lista) {
            total += i.getCantidad() * i.getPrecio();
        }
        return total;
    }

    //El siguiente método recupera la lista completa
    public List<Item> getItems() {
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");
        return lista;
    }

    //El siguiente método elimina un item en la variable de session
    public void delete(Item item) {
        //se recupera la variable session
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");
        //Se valida si la lista ya estaba como variable de session
        if (lista != null) {
            boolean existe = false;
            var posicion = -1;
            for (Item i : lista) {
                posicion++;
                if (Objects.equals(item.getIdProducto(), i.getIdProducto())) {
                    existe = true;
                    break;
                }
            }
            if (existe) { //Si no estaba en la lista se crea en ella...
                lista.remove(posicion);
                session.setAttribute("listaItems", lista);
            }
        }
    }

    //El siguiente metodo actualizala cantidad un item en la variable de session
    public void update(Item item) {
        //se recupera la variable session
        @SuppressWarnings("unchecked")
        List<Item> lista = (List) session.getAttribute("listaItems");
        //Se valida si la lista ya estaba como variable de session
        if (lista != null) {
            boolean existe = false;
            for (Item i : lista) {
                if (Objects.equals(item.getIdProducto(), i.getIdProducto())) {
                    i.setCantidad(item.getCantidad());
                    break;
                }
            }
        }

    }

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private VentaRepository ventaRepository;

    public void facturar() {
        //Se debe recuperar el usuario autenticado y obtener su idUsuario
        String username = "";
        var principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            if (principal != null) {
                username = principal.toString();
            }
        }

        if (username.isBlank()) {
            System.out.println("username en blanco...");
            return;
        }

        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            System.out.println("Usuario no existe en usuarios...");
            return;
        }

        //Se debe registrar la factura incluyendo el usuario
        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaRepository.save(factura);

        //Se debe registrar las ventas de cada producto -actualizando existencias-
        @SuppressWarnings("unchecked")
        List<Item> listaItems = (List) session.getAttribute("listaItems");
        if (listaItems != null) {
            double total = 0;
            for (Item i : listaItems) {
                var producto = productoRepository.getReferenceById(i.getIdProducto());
                if (producto.getExistencias() >= i.getCantidad()) {
                    Venta venta = new Venta(factura.getIdFactura(),
                            i.getIdProducto(),
                            i.getPrecio(),
                            i.getCantidad());
                    ventaRepository.save(venta);
                    producto.setExistencias(producto.getExistencias() - i.getCantidad());
                    productoRepository.save(producto);
                    total += i.getCantidad() * i.getPrecio();
                }
            }

            //Se debe registrar el total de la venta en la factura
            factura.setTotal(total);
            facturaRepository.save(factura);

            //Se debe limpiar el carrito la lista...
            listaItems.clear();
        }
    }
}
