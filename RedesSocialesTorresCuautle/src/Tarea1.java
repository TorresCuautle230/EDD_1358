import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea1 {

	public static void main(String[] args) {
		int num_Segu_Tw_Jun, num_Segu_Tw_Ene;
		
		int posi1, posi2;

		int num1_Vis, num2_Vis;

		String mes1;
		String mes2;
		int x,y=0,z=3;
		int a,b=0;

		Scanner sc = new Scanner(System.in);

		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		Path filePath = Paths.get("src\\presenciaredes.csv");
		try {

			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosDelinea = linea.split(",");
				ArrayList<String> datosTemporal = new ArrayList<String>();
				for (String dato : datosDelinea) {
					datosTemporal.add(dato);
				}
				datos.add(datosTemporal);
			}
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=8;i>=3;i--) {
			x=Integer.parseInt(datos.get(2).get(z));
			
			y=y+x;
			a=Integer.parseInt(datos.get(9).get(z));
			b=b+a;
			z++;
			
		}
		

		num_Segu_Tw_Jun = Integer.parseInt(datos.get(8).get(8));
		num_Segu_Tw_Ene = Integer.parseInt(datos.get(8).get(3));

		System.out.println("la diferencia de seguidores (followers) en Twitter entre el mes de enero y junio es de: "
				+ (num_Segu_Tw_Jun - num_Segu_Tw_Ene));
		System.out.println("promedio de crecimiento de Twitter y Facebook entre los meses de enero a junio:");
		System.out.println("Facebook: " + (y/6));
		System.out.println("Twitter: " + (b/6));

		System.out.println("///////////////");

		System.out.println("Escriba 2 diferentes meses para calcular la diferencia de visualizaciones de YouTube");
		System.out.println("Solo acepta meses entre Enero y Junio ");
		System.out.println(
				"Se debe escribir los nombres de los meses completos, sin abreviaturas y empezando por mayusculas");
		System.out.println("Introdusca el primer mes : ");
		mes1 = sc.nextLine();
		System.out.println(mes1+"///");
		
		System.out.println("Introdusca el segundo mes : ");
		mes2 = sc.nextLine();
		System.out.println(mes2+"///");
		

		if (mes1 == mes2) {
			System.out.println("Debe escribir dos diferentes meses");
		} 
		
			
		
			
			posi1=Integer.parseInt(posicion (mes1));
			posi2=Integer.parseInt(posicion (mes2));
			 
			 
			
				
		
			
			if(posi1>=posi2) {
				num1_Vis=Integer.parseInt(datos.get(16).get(posi1));
				num2_Vis=Integer.parseInt(datos.get(16).get(posi2));
				System.out.println(num1_Vis-num2_Vis);
			}else if(posi1<=posi2) {
				num1_Vis=Integer.parseInt(datos.get(16).get(posi1));
				num2_Vis=Integer.parseInt(datos.get(16).get(posi2));
				System.out.println(num2_Vis-num1_Vis);
			}

		}

	
	
	public static String posicion (String a) {
		if (a == "Enero") {
		   	return "3"; 
		} else if (a == "Febrero") {
			 return "4";
		} else if (a == "Marzo") {
			 return "5";
		} else if (a == "Abril") {
			; return "6";
		}  if (a == "Mayo") {
			 return "7";
		} else 
			return "8";
		
		
	}

	

}
