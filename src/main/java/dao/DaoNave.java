package dao;

// Clases DAO (Data Access Object)
// Son las que cogen los datos y convertirlo en secuencias sql que mandará a la BD.
// Las siglas dao tienen que ver con la gestion de la base de datos.
// Todo lo que este en dao, tiene que ver con la base de datos.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Nave;

// TIP: Hay que haer un Dao por cada entidad.
// Patron Singelton aun mejor.

// Yo quiero que cuando se instancie este objeto (DaoNave), 
// quiero que el constructor de esta clase se conecte.

public class DaoNave {
	
	public static Connection con = null; // patron Singleton, se explicará otro sábado.
	// Connection es el que está haciendo la magia, que ya esá hecha.
	
	public DaoNave() throws SQLException { // este método es el constructor de esta clase.
		
		this.con = DBConexion.getConexion();
		
		// Nada más se cree esta clase DaoNave, se va a conectar nada más empezar.
	}
	
	public void Insertar(Nave n) throws SQLException {
		
		String sql = "INSERT INTO naves (nombre, clase, matricula, descripcion, estado) VALUES (?,?,?,?,?)"; // secuencia sql
		PreparedStatement ps = con.prepareStatement(sql);
		// No tengo que conectarme, yo ya tengo una conexion activa ('con'), 
		// y le metemos la query que queremos utilizar (sql).
		
		// Cargar los datos:
		ps.setString(1, n.getNombre());
		ps.setString(2, n.getClase());
		ps.setString(3, n.getMatricula());
		ps.setString(4, n.getDescripcion());
		ps.setString(5, n.getEstado());
		
		// prepareStatement listo para lanzarlo.
		
		int filas = ps.executeUpdate();
		ps.close();
		
		// executeUpdate porque quiero enviar, si es recibir seria executeQuery.
		// No hace falta cerrar la conexion, porque es un objeto,
		// cuando deje de funcionar el recolector basura de java se lo cargará. Solo cerrar el ps.
	}

}
