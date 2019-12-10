package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;



@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VendedorRepository vendedorRepository; 
	
	
	@Test
	void contextLoads() {
	
		try {
			//Clientes
			Cliente cl= new Cliente();
		    cl.setId(001);
		    cl.setDocumento("75335938");
		    cl.setNombre("Marcos");
		    cl.setFechaNacimiento(new Date(1999,10,26));
		    cl.setLugarNacimiento("Lima");
		    cl.setSexo('M');
		    cl.setObservacion("CLIENTE 1");
		     
		    Cliente cl2= new Cliente();
		    cl2.setId(001);
		    cl2.setDocumento("45678332");
		    cl2.setNombre("Rodrigo");
		    cl2.setFechaNacimiento(new Date(2002,10,8));
		    cl2.setLugarNacimiento("Callao");
		    cl2.setSexo('M');
		    cl2.setObservacion("CLIENTE 2");
		    cl =clienteRepository.save(cl);
		    cl2=clienteRepository.save(cl2);
		    
		    //Tipos
		    Tipo T1 = new Tipo();
		    T1.setTipo_id("T01"); 
		    T1.setNombre("Tipo 1"); 
		    Tipo T2= new Tipo();
		    T2.setTipo_id("T02");
		    T2.setNombre("Tipo 2"); 
		    T1= tipoRepository.save(T1);
		    T2= tipoRepository.save(T2);
		    
		    
		    
		   //Vendedores
		   Vendedor V1 = new Vendedor();
		   V1.setId("001"); 
		   V1.setNombre("Vendedor 1");
		   V1.setDireccion("Av. Husky");
		   V1.setTelefono("993326659");
		   V1.setObservacion("Observacion vendedor 1");
		   V1.setSueldo(40f);
		   
		   Vendedor V2 = new Vendedor();
		   V2.setId("002");
		   V2.setNombre("Vendedor 2");
		   V2.setDireccion("Av. Boxer");
		   V2.setTelefono("998896659");
		   V2.setObservacion("Observacion vendedor 2");
		   V2.setSueldo(40f);
		   
		   V1=vendedorRepository.save(V1);
		   V2=vendedorRepository.save(V2);
		   
		    
		    
		    
		    //Habitaciones
		    Habitacion H1 = new Habitacion();
		    H1.setId(214);
		    H1.setNumeroCamas(2);
		    H1.setDescripcion("Descripcion habitacion");
		    H1.setPrecio(261f);
		    H1.setTipo(T1);
		    H1.setObservacion("OBSERVACION");
		    Habitacion H2 = new Habitacion();
		    H2.setId(214);
		    H2.setNumeroCamas(1);
		    H2.setDescripcion("Descripcion habitacion 2");
		    H2.setPrecio(500f);
		    H2.setTipo(T1);
		    H2.setObservacion("OBSERVACION");
		    
		    H1 = habitacionRepository.save(H1);
		    H2 =habitacionRepository.save(H2);
		    
		    
		    //Alquileres
		    Alquiler A1 = new Alquiler();
		    A1.setCliente(cl);
		    A1.setVendedor(V1);
		    A1.setEstado("Buen estado");
		    A1.setFechaI(new Date(2002,10,8));
		    A1.setFechaF(new Date(2002,11,9));
		    A1.setHabitacion(H1);
		    A1.setId(001);
		    A1.setObservacion("OBSERVACION ALQUILER 1");
		    A1.setPrecio(5000f); 
		     
		    Alquiler A2 = new Alquiler();
		    A2.setCliente(cl2);
		    A2.setVendedor(V2);
		    A2.setEstado("Buen estado");
		    A2.setFechaI(new Date(2002,10,8));
		    A2.setFechaF(new Date(2002,11,9));
		    A2.setHabitacion(H2); 
		    A2.setId(002);
		    A2.setObservacion("OBSERVACION ALQUILER 2");
		    A2.setPrecio(6000f);
		    
		    A1 = alquilerRepository.save(A1);
		    
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	} 

	
	
}
