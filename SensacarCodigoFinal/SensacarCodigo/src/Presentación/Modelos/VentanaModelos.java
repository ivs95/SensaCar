/**
 * 
 */
package Presentación.Modelos;

import javax.swing.JFrame;
import Presentación.Ventana;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class VentanaModelos extends JFrame implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static VentanaModelos instance;

	
	public static VentanaModelos getInstance() {
		if ( instance== null){
			instance= new VentanaModelosImp();
		}
		return instance;
	}

}