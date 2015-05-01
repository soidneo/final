/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitocode.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "producto_categoria", catalog = "control", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCategoria.findAll", query = "SELECT p FROM ProductoCategoria p"),
    @NamedQuery(name = "ProductoCategoria.findById", query = "SELECT p FROM ProductoCategoria p WHERE p.id = :id")})
public class ProductoCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria idCategoria;

    public ProductoCategoria() {
    }

    public ProductoCategoria(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCategoria)) {
            return false;
        }
        ProductoCategoria other = (ProductoCategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mitocode.model.ProductoCategoria[ id=" + id + " ]";
    }
    
}
