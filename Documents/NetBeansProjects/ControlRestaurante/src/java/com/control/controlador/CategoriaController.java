package com.control.controlador;


import com.control.dao.CategoriaFacade;
import com.control.dto.PedidoDetalleDto;
import com.control.dto.PedidoMaestro;
import com.control.entidad.Categoria;
import com.control.entidad.TProductoCategoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "categoriaController")
@SessionScoped
public class CategoriaController implements Serializable {

    @EJB
    private com.control.dao.CategoriaFacade ejbFacade;
    private List<Categoria> items = null;
    private Categoria selected;
    private List<TProductoCategoria>listaProductos;
    private PedidoMaestro pedidoMaestro;
    private TProductoCategoria pedido;
    private PedidoDetalleDto detalle;

    public PedidoDetalleDto getDetalle() {
        return detalle;
    }

    public void setDetalle(PedidoDetalleDto detalle) {
        this.detalle = detalle;
    }
    
    public TProductoCategoria getPedido() {
        return pedido;
    }

    public void setPedido(TProductoCategoria pedido) {
        this.pedido = pedido;
    }

    public PedidoMaestro getPedidoMaestro() {
        return pedidoMaestro;
    }

    public void setPedidoMaestro(PedidoMaestro pedidoMaestro) {
        this.pedidoMaestro = pedidoMaestro;
    } 
    
    public CategoriaController() {
      
    }

    public Categoria getSelected() {
        return selected;
    }

    public void setSelected(Categoria selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoriaFacade getFacade() {
        return ejbFacade;
    }

    public Categoria prepareCreate() {
        selected = new Categoria();
        initializeEmbeddableKey();
        return selected;
    }

    public List<TProductoCategoria> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<TProductoCategoria> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    

   public void asignarCategoria(){
       selected=ejbFacade.find(this.selected.getId());
       this.listaProductos=selected.getTProductoCategoriaList();
     //  this.selected=cat;
   }
   
   public void agregarPedido(){
       detalle.setProducto(pedido);
       pedidoMaestro.getDetallesPedido().add(detalle);
       System.out.println(pedidoMaestro.getDetallesPedido().size());
       detalle=new PedidoDetalleDto();
   }
   @PostConstruct
   public void iniciar(){
       this.items=null;
       this.listaProductos=new ArrayList<TProductoCategoria>();
       this.selected=new Categoria();
       this.pedidoMaestro=new PedidoMaestro();
       this.pedidoMaestro.setDetallesPedido(new ArrayList<PedidoDetalleDto>());
       this.pedido=new TProductoCategoria();
       detalle=new PedidoDetalleDto();
   }

    public List<Categoria> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    
    public List<Categoria> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Categoria> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Categoria.class)
    public static class CategoriaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriaController controller = (CategoriaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Categoria) {
                Categoria o = (Categoria) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Categoria.class.getName()});
                return null;
            }
        }

    }

}
