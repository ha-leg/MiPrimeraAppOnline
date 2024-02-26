package modelo;

import java.sql.SQLException;

import dao.DaoNave;

public class Nave {
	
	// Antes de todo sería la fase de análisis,
	// sería el diagrama de clases, la memoria, la documentación, etc.
	
	private int id; 
	private String nombre;
	private String clase; //debería ser otra clase, no lo es porque somos nobbies.
	private String matricula;
	private String descripcion;
	private String estado;
	
	// Olvidarse del Scanner, todos los datos me los dará el usuario,
	// pero hay que darle medios para ello.
	// Excepto el id que me lo dará la BD.
	
	public Nave() {
		
	}
	

	public Nave(int id, String nombre, String clase, String matricula, String descripcion, String estado) {
		
		this.id = id;
		this.nombre = nombre;
		this.clase = clase;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	// Genero el constructor que me hace falta con los campos que quiero.
	
	public Nave(String nombre, String clase, String matricula, String descripcion, String estado) {
		super();
		this.nombre = nombre;
		this.clase = clase;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void insertar() throws SQLException {
		
		DaoNave dao = new DaoNave();
		dao.Insertar(this); // este insertar es de DaoNave.
		
		// Y ya tendría todo. Este es el final de todo.
		// Ya tengo donde el cliente me rellena un formulario, java lo recibe en el servlet, 
		// llama al metodo insertar, insertar llama a su dao, y su dao lo guarda en la base de datos.
		
	}

	@Override
	public String toString() {
		return "Nave [id=" + id + ", nombre=" + nombre + ", clase=" + clase + ", matricula=" + matricula + ", descripcion=" + descripcion + ", estado="
				+ estado + "]";
	}
	
}
