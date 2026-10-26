package pe.edu.utp.overtext.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 150)
    private String slogan;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "precio_pack")
    private Double precioPack;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "imagen_principal")
    private String imagenPrincipal;

    @Column(name = "color_nombre", nullable = false, length = 40)
    private String colorNombre;

    @Column(name = "color_hex", nullable = false, length = 10)
    private String colorHex;

    @Column(name = "correo_proveedor", nullable = false, length = 100)
    private String correoProveedor;

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Long id, String codigo, String nombre, String slogan, String descripcion,
                    Double precio, Double precioPack, Integer stock, String imagenPrincipal,
                    String colorNombre, String colorHex, String correoProveedor,
                    Boolean activo, Categoria categoria) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.slogan = slogan;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precioPack = precioPack;
        this.stock = stock;
        this.imagenPrincipal = imagenPrincipal;
        this.colorNombre = colorNombre;
        this.colorHex = colorHex;
        this.correoProveedor = correoProveedor;
        this.activo = activo;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioPack() {
        return precioPack;
    }

    public void setPrecioPack(Double precioPack) {
        this.precioPack = precioPack;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }

    public String getColorNombre() {
        return colorNombre;
    }

    public void setColorNombre(String colorNombre) {
        this.colorNombre = colorNombre;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
