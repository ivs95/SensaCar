/**
 * 
 */
package Presentación.Comandos.Departamento;

import Integración.Departamento.TDepartamento;
import Negocio.Factorías.FactoriaNegocio;
import Presentación.Comandos.Command;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author nacho710
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class LeerDepartamentoCommand implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Contexto contexto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Contexto execute(Contexto contexto) {
		TDepartamento d =FactoriaNegocio.getInstance().generaSADepartamento().leerDepartamento((int) contexto.getDato());
		if (d == null) {
			contexto.setEvento(Evento.LeerDepartamentoCommandError);
			contexto.setDato(-1);
		} else
			contexto.setDato(d);
		return contexto;
	}
}