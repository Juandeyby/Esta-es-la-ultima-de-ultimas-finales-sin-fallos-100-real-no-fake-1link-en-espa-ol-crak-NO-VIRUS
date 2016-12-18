package Controladores;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Clases.ParticipanteOut;
import Clases.Participante;
import Clases.ParticipanteBuscar;
import Clases.Historial;
import Clases.ParticipantePDF;
import Clases.Usuario;

public class Conexion {
	
	public void nuevo() {
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if (conn != null) {
			try {
				//Tabla entidad usuario
				prestat = conn.prepareStatement("CREATE TABLE usuario"
						+ "("
						+ "  id_usuario Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_usuario Char(20) NOT NULL,"
						+ "  contrasenia_usuario Char(20) NOT NULL,"
						+ "  pregunta_secreta_usuario Char(50),"
						+ "  respuesta_pregunta_secreta_usuario Char(50),"
						+ "  anio_cuenta_generada_usuario Int,"
						+ "  mes_cuenta_generada_usuario Int,"
						+ "  dia_cuenta_generada_usuario Int,"
						+ "  id_tipo_usuario Int NOT NULL "
						+ ") ");
				System.out.println(prestat.executeUpdate());


				//Tabla entidad_tipo_usuario
				prestat = conn.prepareStatement("CREATE TABLE tipo_usuario"
						+ "("
						+ "  id_tipo_usuario Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_tipo_usuario Char(20) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());


				//Tabla entidad_participante
				prestat = conn.prepareStatement("CREATE TABLE participante"
						+ "("
						+ "	 dni_participante char(8) NOT NULL ,"
						+ "  nombre_participante Char(50) NOT NULL,"
						+ "  apellido_participante Char(50) NOT NULL,"
						+ "  telefono_participante Char(9) ,"
						+ "  telefono_oficina_participante Int,"
						+ "  celular_participante Int NOT NULL,"
						+ "  correo_participante Char(50) NOT NULL,"
						+ "  correo_institucional_participante Char(50) ,"
						+ "  direccion_participante Char(200) NOT NULL,"
						+ "  estado_participante Boolean NOT NULL,"
						+ "  id_facultad Int," //10
						+ "  id_especialidad Int," //11
						+ "  id_tipo_condicion Int," // 12
						+ "  id_funcion Int," //13
						+ "  id_tipo_participante Int"
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_funcion
				prestat = conn.prepareStatement("CREATE TABLE funcion"
						+ "("
						+ "  id_funcion Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_funcion Char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());


				//Tabla entidad_departamento
				prestat = conn.prepareStatement("CREATE TABLE departamento"
						+ "("
						+ "  id_departamento Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_departamento Char(50) NOT NULL,"
						+ "  id_facultad Int NOT NULL "
						+ ") ");
				System.out.println(prestat.executeUpdate());


				//Tabla entidad_facultad
				prestat = conn.prepareStatement("CREATE TABLE facultad"
						+ "("
						+ "  id_facultad Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_facultad Char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_especialidad
				prestat = conn.prepareStatement("CREATE TABLE especialidad"
						+ "("
						+ "  id_especialidad Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_especialidad Char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());



				//Tabla entidad_tipo_condicion
				prestat = conn.prepareStatement("CREATE TABLE tipo_condicion"
						+ "("
						+ "  id_tipo_condicion Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_tipo_condicion Char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());


				
				//Tabla entidad_tipo_proceso
				prestat = conn.prepareStatement("CREATE TABLE tipo_proceso"
						+ "("
						+ "  id_tipo_proceso Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_tipo_proceso Char(30) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_fase_proceso
				prestat = conn.prepareStatement("CREATE TABLE fase_proceso"
						+ "("
						+ "  id_fase_proceso Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_fase_proceso Char(30) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());
				
				//Tabla entidad_lista cabecera
				prestat = conn.prepareStatement("CREATE TABLE lista_cabecera"
						+ "("
						+ "  id_lista_cabecera Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  id_fase_proceso Int ,"
						+ "  id_tipo_proceso Int , "
						+ "  anio_proceso Int NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_lista_detalle
				prestat = conn.prepareStatement("CREATE TABLE lista_detalle"
						+ "("
						+ "  id_lista_cabecera Int NOT NULL,"
						+ "  dni_participante Char(8) NOT NULL,"
						+ "  id_cargo_proceso Int NOT NULL"
					
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_tipo_participante
				prestat = conn.prepareStatement("CREATE TABLE tipo_participante"
						+ "("
						+ "  id_tipo_participante Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+ "  nombre_tipo_participante char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());


				//Tabla entidad_cargo_proceso
				prestat = conn.prepareStatement("CREATE TABLE cargo_proceso"
						+ "("
						+ "  id_cargo_proceso Int NOT NULL  primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+  "nombre_cargo_proceso char(50) NOT NULL"
						+ ") ");
				System.out.println(prestat.executeUpdate());

				//Tabla entidad_historial_proceso
				prestat = conn.prepareStatement("CREATE TABLE historial_proceso"
						+ "("
						+ "  id_historial_proceso Int NOT NULL  primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
						+  "dni_participante char(8) NOT NULL,"
						+ " id_tipo_proceso Int NOT NULL,"
						+ "  id_fase_proceso Int NOT NULL,"
						+ "  anio_proceso Int NOT NULL,"
						+ "  id_cargo_proceso Int NOT NULL,"
						+ "  experiencia_historial_proceso Int NOT NULL,"
						+ "  observacion_historial_proceso char(200)"
						+ ") ");
				System.out.println(prestat.executeUpdate());


			

				/**LOS INDEX*/
				//index1
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship8 ON participante (id_facultad)");
				System.out.println(prestat.executeUpdate());

				//index2
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship9 ON participante (id_especialidad)");
				System.out.println(prestat.executeUpdate());

				//index3
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship10 ON participante (id_tipo_condicion)");
				System.out.println(prestat.executeUpdate());

				//index4
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship11 ON participante (id_funcion)");
				System.out.println(prestat.executeUpdate());
				
				//index5
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship17 ON participante (id_tipo_participante)");
				System.out.println(prestat.executeUpdate());
				
				//index6
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship52 ON lista_cabecera (id_fase_proceso)");
				System.out.println(prestat.executeUpdate());

				//index7
				prestat = conn.prepareStatement("CREATE INDEX IX_Relationship53 ON lista_cabecera (id_tipo_proceso)");
				System.out.println(prestat.executeUpdate());


				/*****alter********/


//				//
//				//
//				//				////*****alter********
//				//				
//				//				//alter1
				prestat = conn.prepareStatement( "ALTER TABLE usuario ADD  UNIQUE (nombre_usuario)");
				System.out.println(prestat.executeUpdate());
//
//				//alter2
				prestat = conn.prepareStatement( "ALTER TABLE tipo_usuario ADD  UNIQUE (nombre_tipo_usuario)");
				System.out.println(prestat.executeUpdate());
//
//				//alter3			
//				//				prestat = conn.prepareStatement( "ALTER TABLE participante ADD  PRIMARY KEY (dni_participante)");
//				//				System.out.println(prestat.executeUpdate());
//
//				//alter4-- aqui tmb hay dudaa
				prestat = conn.prepareStatement("ALTER TABLE participante ADD  UNIQUE (dni_participante)");
				System.out.println(prestat.executeUpdate());
//
//
//				//alter5
				prestat = conn.prepareStatement("ALTER TABLE funcion ADD  UNIQUE (nombre_funcion)");
				System.out.println(prestat.executeUpdate());	

				//alter6
				prestat = conn.prepareStatement("ALTER TABLE departamento ADD UNIQUE (nombre_departamento)");
				System.out.println(prestat.executeUpdate());


				//alter7
				prestat = conn.prepareStatement("ALTER TABLE facultad ADD UNIQUE (nombre_facultad)");
//				System.out.println(prestat.executeUpdate());	
//
//
//				//alter8
				prestat = conn.prepareStatement("ALTER TABLE especialidad ADD UNIQUE (nombre_especialidad)");
				System.out.println(prestat.executeUpdate());	
//
//
//
//				//alter9
				prestat = conn.prepareStatement("ALTER TABLE tipo_condicion ADD UNIQUE (nombre_tipo_condicion)");
				System.out.println(prestat.executeUpdate());
//
//				//alter10
				prestat = conn.prepareStatement("ALTER TABLE tipo_proceso ADD UNIQUE (nombre_tipo_proceso)");
				System.out.println(prestat.executeUpdate());
//
//				//alter11
				prestat = conn.prepareStatement("ALTER TABLE fase_proceso ADD UNIQUE (nombre_fase_proceso)");
				System.out.println(prestat.executeUpdate());

//				//alter13
				prestat = conn.prepareStatement("ALTER TABLE lista_detalle ADD PRIMARY KEY (id_lista_cabecera,id_cargo_proceso,dni_participante)");
				System.out.println(prestat.executeUpdate());
//
//
//				//alter14
				prestat = conn.prepareStatement("ALTER TABLE tipo_participante ADD UNIQUE  (nombre_tipo_participante)");
				System.out.println(prestat.executeUpdate());
//
//				//alter15-- aaqui tengo duda
				prestat = conn.prepareStatement( "ALTER TABLE cargo_proceso ADD UNIQUE (nombre_cargo_proceso) ");
				System.out.println(prestat.executeUpdate());
//
//				//alter17
//				prestat = conn.prepareStatement( "ALTER TABLE historial_proceso ADD PRIMARY KEY (id_historial_proceso,dni_participante,id_tipo_proceso,id_fase_proceso,id_cargo_proceso)");
//				System.out.println(prestat.executeUpdate());

//				//alter19
				prestat = conn.prepareStatement("ALTER TABLE participante ADD CONSTRAINT Relationship8 FOREIGN KEY (id_facultad) REFERENCES facultad (id_facultad) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());

//				//alter20
				prestat = conn.prepareStatement("ALTER TABLE participante ADD CONSTRAINT Relationship9 FOREIGN KEY (id_especialidad) REFERENCES especialidad (id_especialidad) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());

//				//alter21
				prestat = conn.prepareStatement("ALTER TABLE participante ADD CONSTRAINT Relationship10 FOREIGN KEY (id_tipo_condicion) REFERENCES tipo_condicion (id_tipo_condicion) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter22
				prestat = conn.prepareStatement("ALTER TABLE participante ADD CONSTRAINT Relationship11 FOREIGN KEY (id_funcion) REFERENCES funcion (id_funcion) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter23
				prestat = conn.prepareStatement("ALTER TABLE lista_detalle ADD CONSTRAINT Relationship12 FOREIGN KEY (id_lista_cabecera) REFERENCES lista_cabecera (id_lista_cabecera) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter25
				prestat = conn.prepareStatement("ALTER TABLE lista_detalle ADD CONSTRAINT Relationship16 FOREIGN KEY (dni_participante) REFERENCES participante (dni_participante) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
////
//				//alter26
				prestat = conn.prepareStatement("ALTER TABLE participante ADD CONSTRAINT Relationship17 FOREIGN KEY (id_tipo_participante) REFERENCES tipo_participante (id_tipo_participante) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter27
				prestat = conn.prepareStatement("ALTER TABLE departamento ADD CONSTRAINT Relationship19 FOREIGN KEY (id_facultad) REFERENCES facultad (id_facultad) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());

//				//alter28
				prestat = conn.prepareStatement("ALTER TABLE historial_proceso ADD CONSTRAINT Relationship30 FOREIGN KEY (id_cargo_proceso) REFERENCES cargo_proceso (id_cargo_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
				//alter28
				prestat = conn.prepareStatement("ALTER TABLE historial_proceso ADD CONSTRAINT Relationship37 FOREIGN KEY (id_tipo_proceso) REFERENCES tipo_proceso (id_tipo_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter29
				prestat = conn.prepareStatement("ALTER TABLE usuario ADD CONSTRAINT Relationship38 FOREIGN KEY (id_tipo_usuario) REFERENCES tipo_usuario (id_tipo_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
//				//alter30
				prestat = conn.prepareStatement("ALTER TABLE historial_proceso ADD CONSTRAINT Relationship44 FOREIGN KEY (id_fase_proceso) REFERENCES fase_proceso (id_fase_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());

//				//alter36
				prestat = conn.prepareStatement("ALTER TABLE lista_cabecera ADD CONSTRAINT Relationship52 FOREIGN KEY (id_fase_proceso) REFERENCES fase_proceso (id_fase_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
//
////				//alter37 
				prestat = conn.prepareStatement( "ALTER TABLE lista_cabecera ADD CONSTRAINT Relationship53 FOREIGN KEY (id_tipo_proceso) REFERENCES tipo_proceso(id_tipo_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());

//				//alter38
				prestat = conn.prepareStatement( "ALTER TABLE lista_detalle ADD CONSTRAINT Relationship54 FOREIGN KEY (id_cargo_proceso) REFERENCES cargo_proceso(id_cargo_proceso) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
				
				//alter39
				prestat = conn.prepareStatement( "ALTER TABLE historial_proceso ADD CONSTRAINT Relationship55 FOREIGN KEY (dni_participante) REFERENCES participante(dni_participante) ON DELETE RESTRICT ON UPDATE RESTRICT");
				System.out.println(prestat.executeUpdate());
				
				//Tipo Proceso
				prestat = conn.prepareStatement("INSERT INTO tipo_proceso (nombre_tipo_proceso)"
						+ " VALUES ('ORDINARIO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO tipo_proceso (nombre_tipo_proceso)"
						+ " VALUES ('CEPREUNSA')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO tipo_proceso (nombre_tipo_proceso)"
						+ " VALUES ('EXTRAORDINARIO')");
				System.out.println(prestat.executeUpdate());
				
				//Fase Proceso
				prestat = conn.prepareStatement("INSERT INTO fase_proceso (nombre_fase_proceso)"
						+ " VALUES ('I')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO fase_proceso (nombre_fase_proceso)"
						+ " VALUES ('II')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO fase_proceso (nombre_fase_proceso)"
						+ " VALUES ('III')");
				System.out.println(prestat.executeUpdate());
				
				//Función
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('DIRECTORESCUELA')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('CONSEJERO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('DIRECTORDEPARTAMENTO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('DOCENTE')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('COORDINADOR')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('JEFEPRACTICAS')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('DECANO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('SECRETARIA')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('PORTERO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('CONSERJE')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('BIBLIOTECARIO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO funcion (nombre_funcion)"
						+ " VALUES ('SINFUNCION')");
				System.out.println(prestat.executeUpdate());
				
				//Tipo Condición
				prestat = conn.prepareStatement("INSERT INTO tipo_condicion (nombre_tipo_condicion)"
						+ " VALUES ('NOMBRADO')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO tipo_condicion (nombre_tipo_condicion)"
						+ " VALUES ('CONTRATADO')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO tipo_condicion (nombre_tipo_condicion)"
						+ " VALUES ('INVITADO')");
				System.out.println(prestat.executeUpdate());
				
				//Tipo Participante
				prestat = conn.prepareStatement("INSERT INTO tipo_participante (nombre_tipo_participante)"
						+ " VALUES ('DOCENTE')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO tipo_participante (nombre_tipo_participante)"
						+ " VALUES ('ADMINISTRATIVO')");
				System.out.println(prestat.executeUpdate());
				
				//Especialidad
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('QUIMICA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('BIOLOGIA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('FISICA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('LENGUAJE')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('LITERATURA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('HISTORIA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('GEOGRAFIA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('FILOSOFIA')");
				System.out.println(prestat.executeUpdate());

				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('PSICOLOGIA')");
				System.out.println(prestat.executeUpdate());

				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('MATEMATICA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('RAZVERBAL')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('RAZMATEMATICO')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO especialidad (nombre_especialidad)"
						+ " VALUES ('SINFUNCION')");
				System.out.println(prestat.executeUpdate());
				
				//Facultad
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('CIENCIASBIOLOGICAS')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('AGRONOMIA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('ENFERMERIA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('MEDICINA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('ARQUITECTURA')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('CIENCIASNATURALESYFORMALES')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('GEOLOGIAGEOFISICAYMINAS')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('INGENIERIACIVIL')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('INGENIERIADEPROCESOS')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('INGENIERIADEPRODUCCIONYS')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('EDUCACION')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('CIENCIASHISTORICOSOCIALES')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('DERECHO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('ECONOMIA')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('FILOSOFIAYHUMANIDADES')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('PSICOLOGIARIYCS')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('ADMINISTRACION')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO facultad (nombre_facultad)"
						+ " VALUES ('CIENCIASCONTABLESYFIN')");
				System.out.println(prestat.executeUpdate());
				
				//Cargo Proceso
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('FORMULADOR')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('TECNICO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('CONTROLADOR')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('CONTADOR')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('CONSERJE')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('PORTERO')");
				System.out.println(prestat.executeUpdate());
				prestat = conn.prepareStatement("INSERT INTO cargo_proceso (nombre_cargo_proceso)"
						+ " VALUES ('VERIFICADOR')");
				System.out.println(prestat.executeUpdate());
				
				//Tipo de Usuarios
				prestat = conn.prepareStatement("INSERT INTO tipo_usuario (nombre_tipo_usuario)"
						+ " VALUES ('ADMINISTRADOR')");
				System.out.println(prestat.executeUpdate());
				
				prestat = conn.prepareStatement("INSERT INTO tipo_usuario (nombre_tipo_usuario)"
						+ " VALUES ('JEFEPROCESO')");
				System.out.println(prestat.executeUpdate());

				//Administrador
				prestat = conn.prepareStatement("INSERT INTO usuario (nombre_usuario, contrasenia_usuario,"
						+ " pregunta_secreta_usuario, respuesta_pregunta_secreta_usuario,"
						+ " anio_cuenta_generada_usuario, mes_cuenta_generada_usuario,"
						+ " dia_cuenta_generada_usuario, id_tipo_usuario)"
						+ " VALUES ('admin', 'admin', '¿Como ese llama mí gato?', 'Luna', 3000, 12, 31, 1)");
				System.out.println(prestat.executeUpdate());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			prestat = conn.prepareStatement("SELECT * FROM usuario");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				System.out.println(pw.getInt("id_usuario") + "," + pw.getString("nombre_usuario") + "," +
						pw.getString("contrasenia_usuario") + "," + pw.getString("pregunta_secreta_usuario") + "," +
						pw.getString("respuesta_pregunta_secreta_usuario") + "," + pw.getInt("id_tipo_usuario"));
			}
			
			prestat.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario consulta(String nombre_usuario) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			prestat = conn.prepareStatement("SELECT * FROM usuario WHERE nombre_usuario = '" + nombre_usuario + "'");
			pw = prestat.executeQuery();
			
			
			Usuario usuario;
			if (pw.next()) {
				usuario = new Usuario (
						pw.getInt("id_usuario"),
						refinar(pw.getString("nombre_usuario")),
						refinar(pw.getString("contrasenia_usuario")),
						refinar(pw.getString("pregunta_secreta_usuario")),
						refinar(pw.getString("respuesta_pregunta_secreta_usuario")),
						pw.getInt("anio_cuenta_generada_usuario"),
						pw.getInt("mes_cuenta_generada_usuario"),
						pw.getInt("dia_cuenta_generada_usuario"),
						pw.getInt("id_tipo_usuario"));
			} else {
				return null;
			}
			
			prestat = conn.prepareStatement("SELECT * FROM usuario");
			pw = prestat.executeQuery();
			
			ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
			
			Date date = new Date();
			
			while (pw.next()) {
				Date deteTemp = new Date(pw.getInt("anio_cuenta_generada_usuario"),
						pw.getInt("mes_cuenta_generada_usuario"),
						pw.getInt("dia_cuenta_generada_usuario"));
				
				System.out.println(date.compareTo(deteTemp));
				System.out.println(date.toString());
				System.out.println(deteTemp.toString());
				
				
				if(date.compareTo(deteTemp) >= 0) {
					Usuario temp = new Usuario(pw.getInt("id_usuario"),
							pw.getInt("anio_cuenta_generada_usuario"),
							pw.getInt("mes_cuenta_generada_usuario"), 
							pw.getInt("dia_cuenta_generada_usuario"));
					usuarios.add(temp);
				}
			}
				
			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println("Se elimino" + usuarios.get(i).getId_usuario());
				prestat = conn.prepareStatement("DELETE FROM usuario WHERE id_usuario=" + usuarios.get(i).getId_usuario() + "");
				System.out.println(prestat.executeUpdate());
			}
			
			try {
				prestat = conn.prepareStatement("SELECT * FROM usuario");
				pw = prestat.executeQuery();
				
				while (pw.next()) {
					System.out.println(pw.getInt("id_usuario") + "," + pw.getString("nombre_usuario") + "," +
							pw.getString("contrasenia_usuario") + "," + pw.getString("pregunta_secreta_usuario") + "," +
							pw.getString("respuesta_pregunta_secreta_usuario") + "," +
							pw.getString("anio_cuenta_generada_usuario") + "," +
							pw.getString("mes_cuenta_generada_usuario") + "," +
							pw.getString("dia_cuenta_generada_usuario") + "," +
							pw.getInt("id_tipo_usuario"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			prestat = conn.prepareStatement("SELECT * FROM participante");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				System.out.println(pw.getString("nombre_participante") + "," +
						pw.getString("nombre_participante"));
			}
			
			conn.close();
			prestat.close();
			pw.close();
			
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertarSeleccionado (int id_participante, int id_cargo_proceso) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			//Seleccionado
			prestat = conn.prepareStatement("INSERT INTO seleccionado ("
					+ " id_participante, id_cargo_proceso,"
					+ " VALUES ('" + id_participante + "', '" + id_cargo_proceso + "'");
			System.out.println(prestat.executeUpdate());
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public ArrayList<Seleccionado> consultarSeleccionado(int id_participante) {
//		
//		Connection conn = null;
//		PreparedStatement prestat = null;
//		ResultSet pw = null;
//		ArrayList<Seleccionado> seleccionados= new ArrayList<Seleccionado>();
//		
//		try {
//			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//		} catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//		
//		try {
//			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			//Seleccionado
//			prestat = conn.prepareStatement("SELECT * FROM participante, cargo_proceso");
//			pw = prestat.executeQuery();
//			
////			public Seleccionado(int id_participante, String dni_participante, String nombre_participante,
////					String apellido_participante, int telefono_participante, int telefono_oficina_participante,
////					int celular_participante, String correo_participante, String correo_institucional_participante,
////					String direccion_participante, boolean estado_participante, int id_facultad, int id_especialidad,
////					int id_tipo_condicion, int id_funcion, int id_tipo_participante, int id_historial_proceso_cabecera,
////					int id_cargo_proceso) {
//			
//			Seleccionado seleccionado;
//			if (pw.next()) {
//				seleccionado = new Seleccionado (
//						pw.getInt("id_participante"),
//						refinar(pw.getString("dni_participante")),
//						refinar(pw.getString("nombre_participante")),
//						refinar(pw.getString("apellido_participante")),
//						pw.getInt("telefono_participante"),
//						pw.getInt("telefono_oficina_participante"),
//						pw.getInt("celular_participante"),
//						refinar(pw.getString("correo_participante")),
//						refinar(pw.getString("correo_institucional_participante")),
//						refinar(pw.getString("direccion_participante")),
//						pw.getBoolean("estado_participante"),
//						pw.getInt("id_facultad"),
//						pw.getInt("id_especialidad"),
//						pw.getInt("id_tipo_condicion"),
//						pw.getInt("id_funcion"),
//						pw.getInt("id_tipo_participante"),
//						pw.getInt("id_historial_proceso_cabecera"),
//						pw.getInt("id_cargo_proceso"));
//				seleccionados.add(seleccionado);
//				
//			} else {
//				return null;
//			}
//			return seleccionados;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public Usuario insertarUsuario (Usuario usuario) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			//Jefe de Proceso
			prestat = conn.prepareStatement("INSERT INTO usuario (nombre_usuario, contrasenia_usuario,"
					+ " pregunta_secreta_usuario, respuesta_pregunta_secreta_usuario,"
					+ " anio_cuenta_generada_usuario, mes_cuenta_generada_usuario,"
					+ " dia_cuenta_generada_usuario, id_tipo_usuario)"
					+ " VALUES ('"+ usuario.getNombre_usuario() +"', '"
					+ usuario.getContrasenia_usuario() +"', NULL, NULL, "
					+ usuario.getAnio_cuenta_generada_usuario() +", "
					+ usuario.getMes_cuenta_generada_usuario() +", "
					+ usuario.getDia_cuenta_generada_usuario() + ", 2)");
			System.out.println(prestat.executeUpdate());
			
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean crearCabezera (int fase_proceso, String tipo_proceso, int anio_proceso) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			int tipo_proceso_int = 0;
			if (tipo_proceso.equals("ORDINARIO"))
				tipo_proceso_int = 1;
			else if (tipo_proceso.equals("CEPREUNSA"))
				tipo_proceso_int = 2;
			else if (tipo_proceso.equals("EXTRAORDINARIO"))
				tipo_proceso_int = 3;
			
			prestat = conn.prepareStatement("INSERT INTO lista_cabecera (id_fase_proceso, id_tipo_proceso, anio_proceso)"
					+ " VALUES ("
					+ fase_proceso +", "
					+ tipo_proceso_int +", "
					+ anio_proceso + ")");
			System.out.println(prestat.executeUpdate());
			
			prestat = conn.prepareStatement("SELECT * FROM lista_cabecera");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				System.out.print(pw.getInt("id_lista_cabecera") + " ");
				System.out.print(pw.getInt("id_fase_proceso") + " ");
				System.out.print(pw.getInt("id_tipo_proceso") + " ");
				System.out.print(pw.getInt("anio_proceso"));
				System.out.println();
			}
			
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertarExportar (int cargo, List<ParticipanteBuscar> participantesBuscar) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {

			for (int i = 0; i < participantesBuscar.size(); i++) {
				if (!participantesBuscar.get(i).isBuscar()) {
					prestat = conn.prepareStatement("INSERT INTO lista_detalle (id_lista_cabecera, dni_participante, id_cargo_proceso)"
							+ " VALUES ( 1, '" + participantesBuscar.get(i).getDni_participante() + "', " + cargo + " )");
					System.out.println(prestat.executeUpdate());
				}
			}
			
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ParticipanteOut perfil(String dni_participante, String funcion, String tipo_participante) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		ParticipanteOut participante = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
//		Tabla entidad_tipo_participante
//		prestat = conn.prepareStatement("CREATE TABLE tipo_participante"
//				+ "("
//				+ "  id_tipo_participante Int NOT NULL primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
//				+ "  nombre_tipo_participante char(50) NOT NULL"
//				+ ") ");
//		System.out.println(prestat.executeUpdate());
		
		try {
			prestat = conn.prepareStatement("SELECT * FROM participante, tipo_participante, funcion WHERE participante.dni_participante = '"+ dni_participante + "' AND funcion.nombre_funcion = '" + funcion + "' AND tipo_participante.nombre_tipo_participante = '" + tipo_participante +"'");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				ParticipanteOut participanteTemp = new ParticipanteOut(
						pw.getString("dni_participante"),
						refinar(pw.getString("nombre_participante")),
						refinar(pw.getString("apellido_participante")),
						refinar(pw.getString("telefono_participante")),
						pw.getInt("telefono_oficina_participante"),
						pw.getInt("celular_participante"),
						refinar(pw.getString("correo_participante")),
						refinar(pw.getString("correo_institucional_participante")),
						refinar(pw.getString("direccion_participante")),
						pw.getBoolean("estado_participante"),
						refinar(pw.getString("id_facultad")),
						refinar(pw.getString("id_especialidad")),
						refinar(pw.getString("id_tipo_condicion")),
						refinar(pw.getString("nombre_funcion")),
						refinar(pw.getString("nombre_tipo_participante")));
				System.out.println(participanteTemp.toString());
				participante = participanteTemp;
			}
			System.out.println(pw);
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participante;
	}

	public ArrayList<ParticipanteOut> mostrar () {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		ArrayList<ParticipanteOut> participantes = new ArrayList<ParticipanteOut>();
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		try {
			prestat = conn.prepareStatement("SELECT * FROM participante, especialidad, tipo_participante, funcion WHERE participante.id_funcion = funcion.id_funcion AND participante.id_funcion = especialidad.id_especialidad AND participante.id_tipo_participante = tipo_participante.id_tipo_participante");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				ParticipanteOut participanteTemp = new ParticipanteOut(
						pw.getString("dni_participante"),
						refinar(pw.getString("nombre_participante")),
						refinar(pw.getString("apellido_participante")),
						refinar(pw.getString("telefono_participante")),
						pw.getInt("telefono_oficina_participante"),
						pw.getInt("celular_participante"),
						refinar(pw.getString("correo_participante")),
						refinar(pw.getString("correo_institucional_participante")),
						refinar(pw.getString("direccion_participante")),
						pw.getBoolean("estado_participante"),
						refinar(pw.getString("id_facultad")),
						refinar(pw.getString("nombre_especialidad")),
						refinar(pw.getString("id_tipo_condicion")),
						refinar(pw.getString("nombre_funcion")),
						refinar(pw.getString("nombre_tipo_participante")));
				participantes.add(participanteTemp);
			}
			System.out.println(pw);
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participantes;
	}
	
	public void insertarParticipante (Participante participante) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			
			//Agregar Participante
			prestat = conn.prepareStatement("INSERT INTO participante (dni_participante, "
					+ " nombre_participante, apellido_participante,"
					+ " telefono_participante, telefono_oficina_participante, celular_participante, correo_participante,"
					+ " correo_institucional_participante, direccion_participante, estado_participante,"
					+ " id_facultad, id_especialidad, id_tipo_condicion, id_funcion, id_tipo_participante"
					+ " )"
					+ " VALUES ("
					+ " '" + participante.getDni_participante() + "',"
					+ " '" + participante.getNombre_participante() + "',"
					+ " '" + participante.getApellido_participante()+ "',"
					+ " '" + participante.getTelefono_participante()+ "',"
					+ participante.getTelefono_oficina_participante()+ ","
					+ participante.getCelular_participante()+ ","
					+ " '" + participante.getCorreo_participante()+ "',"
					+ " '" + participante.getCorreo_institucional_participante()+ "',"
					+ " '" + participante.getDireccion_participante()+ "',"
					+ participante.isEstado_participante()+ ","
					+ participante.getId_facultad()+ ","
					+ participante.getId_especialidad()+ ","
					+ participante.getId_tipo_condicion()+ ","
					+ participante.getId_funcion()+ ","
					+ participante.getId_tipo_participante()
					+ ")");
			System.out.println(prestat.executeUpdate());
			
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarHistorial (Historial historial) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		ResultSet pw = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println(historial.toString());
			prestat = conn.prepareStatement("INSERT INTO historial_proceso (dni_participante, "
					+ " id_tipo_proceso, id_fase_proceso, anio_proceso,"
					+ " id_cargo_proceso, experiencia_historial_proceso, observacion_historial_proceso)"
					+ " VALUES ("
					+ "'" + historial.getDni_participante() + "',"
					+ historial.getId_tipo_proceso() + ","
					+ historial.getId_fase_proceso() + ","
					+ historial.getId_cargo_proceso() + ","
					+ historial.getAnio_proceso() + ","
					+ historial.getExperiencia_historial_proceso() + ","
					+ " '" + historial.getObservacion_historial_proceso() + "' "
					+ ")");
			System.out.println(prestat.executeUpdate());
			
			prestat = conn.prepareStatement("SELECT * FROM historial_proceso");
			pw = prestat.executeQuery();
			
			while (pw.next()) {
				System.out.println(
						pw.getString("dni_participante") + "\t"
						+ pw.getInt("id_tipo_proceso") + "\t"
						+ pw.getInt("id_fase_proceso") + "\t"
						+ pw.getInt("anio_proceso") + "\t"
						+ pw.getInt("id_cargo_proceso") + "\t"
						+ pw.getInt("experiencia_historial_proceso") + "\t"
						+ refinar(pw.getString("observacion_historial_proceso"))
						);
			}
			
			conn.close();
			prestat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambioEstadoParticipante (String dni_participante, boolean estado) {
		
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Statement sta;
		try {
			sta = conn.createStatement();
			String sentece = "UPDATE participante SET estado_participante = " + estado
					+ " WHERE dni_participante = '" + dni_participante + "'";
			System.out.println(sta.executeUpdate(sentece));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int cambioContraseniaAdministrador (String contrasenia_usuario) {
		System.out.println(contrasenia_usuario);
		Connection conn = null;
		PreparedStatement prestat = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try {
			conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Statement sta;
		try {
			sta = conn.createStatement();
			String sentece = "UPDATE usuario SET contrasenia_usuario = '" + contrasenia_usuario + "'"
					+ " WHERE id_usuario = " + 1;
			return sta.executeUpdate(sentece);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	
public static  boolean eliminar() {
	Connection conn = null;
	PreparedStatement prestat = null;
	
	try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	} catch (ClassNotFoundException e) {
        e.printStackTrace();
		System.out.println("error3"+e.getMessage());

    }
	
	try {
		conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
		
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("error1"+e1.getMessage());

	}

	try {
		//Jefe de Proceso
		prestat = conn.prepareStatement("DELETE  FROM lista_detalle");
		System.out.println(prestat.executeUpdate());
		
		conn.close();
		prestat.close();
		
	} catch (SQLException e) {
//		e.printStackTrace();
		System.out.println("error"+e.getMessage());
		return false;	
	}
	return true;
		
	}


public ArrayList<ParticipantePDF> mostrarNuevo() {
	
	Connection conn = null;
	PreparedStatement prestat = null;
	ResultSet pw = null;
	ArrayList<ParticipantePDF> participantes = new ArrayList<ParticipantePDF>();
	
	try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	} catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
	
	try {
		conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
	} catch (SQLException e1) {
		e1.printStackTrace();
	}

	try {
		prestat = conn.prepareStatement("SELECT dni_participante, nombre_participante, "
				+ "apellidos_participante, nombre_cargo_proceso FROM participante, "
				+ "cargo_proceso, lista_detalle WHERE participante.dni_participante = lista_detalle.dni_participante "
				+ "AND cargo_proceso.id_cargo_proceso = lista_detalle.id_cargo_proceso ");
		pw = prestat.executeQuery();
		
		while (pw.next()) {
			ParticipantePDF participanteTemp = new ParticipantePDF(
					pw.getString("dni_participante"),
					refinar(pw.getString("nombre_participante")),
					refinar(pw.getString("apellido_participante")),
					refinar(pw.getString("nombre_cargo_proceso")));
			participantes.add(participanteTemp);
		}
		System.out.println(pw);
		conn.close();
		prestat.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return participantes;
}

	
	public String refinar (String str) {
		if (str ==  null) {
			return null;
		}
		int i = str.length()-1;
		while (i >= 0) {
			if(str.charAt(i) != ' ')
				break;
			i--;
		}
		return str.substring(0, i+1);
	}
}
