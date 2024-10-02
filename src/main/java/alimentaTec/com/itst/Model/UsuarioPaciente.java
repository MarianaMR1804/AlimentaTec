package alimentaTec.com.itst.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String genero;
    private float altura;
    private String contrasenia;
    private String correo;
    private float peso;
    private String padecimiento;
    private int UsuarioPaciente_id;



public int getUsuarioPaciente_id() {
        return UsuarioPaciente_id;
    }

    public void setUsuarioPaciente_id(int usuarioPaciente_id) {
        UsuarioPaciente_id = usuarioPaciente_id;
    }

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellidoPaterno() {
    return apellidoPaterno;
}

public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
}

public String getApellidoMaterno() {
    return apellidoMaterno;
}

public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public float getAltura() {
    return altura;
}

public void setAltura(float altura) {
    this.altura = altura;
}

public String getContrasenia() {
    return contrasenia;
}

public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public float getPeso() {
    return peso;
}

public void setPeso(float peso) {
    this.peso = peso;
}

public String getPadecimiento() {
    return padecimiento;
}

public void setPadecimiento(String padecimiento) {
    this.padecimiento = padecimiento;
}

@Override
public String toString() {
    return "UsuarioPaciente [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
            + apellidoMaterno + ", edad=" + edad + ", genero=" + genero + ", altura=" + altura + ", contrasenia="
            + contrasenia + ", correo=" + correo + ", peso=" + peso + ", padecimiento=" + padecimiento + "]";
}


}
