package alimentaTec.com.itst.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Nutriologo {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellidoPaternoN;
    private String apellidoMaternoN;
    private int edadN;
    private String generoN;
    private String contraseniaN;
    private String correoN;
    private String matricula;
    private int Nutriologo_id;
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaternoN() {
        return apellidoPaternoN;
    }
    public String getApellidoMaternoN() {
        return apellidoMaternoN;
    }
    public int getEdadN() {
        return edadN;
    }
    public String getGeneroN() {
        return generoN;
    }
    public String getContraseniaN() {
        return contraseniaN;
    }
    public String getCorreoN() {
        return correoN;
    }
    public String getMatricula() {
        return matricula;
    }
    public int getNutriologo_id() {
        return Nutriologo_id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidoPaternoN(String apellidoPaternoN) {
        this.apellidoPaternoN = apellidoPaternoN;
    }
    public void setApellidoMaternoN(String apellidoMaternoN) {
        this.apellidoMaternoN = apellidoMaternoN;
    }
    public void setEdadN(int edadN) {
        this.edadN = edadN;
    }
    public void setGeneroN(String generoN) {
        this.generoN = generoN;
    }
    public void setContraseniaN(String contraseniaN) {
        this.contraseniaN = contraseniaN;
    }
    public void setCorreoN(String correoN) {
        this.correoN = correoN;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setNutriologo_id(int nutriologo_id) {
        Nutriologo_id = nutriologo_id;
    }
    @Override
    public String toString() {
        return "Nutriologo [nombre=" + nombre + ", apellidoPaternoN=" + apellidoPaternoN + ", apellidoMaternoN="
                + apellidoMaternoN + ", edadN=" + edadN + ", generoN=" + generoN + ", contraseniaN=" + contraseniaN
                + ", correoN=" + correoN + ", matricula=" + matricula + ", Nutriologo_id=" + Nutriologo_id + "]";
    }
  
}
