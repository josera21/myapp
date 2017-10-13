package controlador;

import modelo.Profesor;
import dao.daoProfesor;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

public class CProfesor extends SelectorComposer {
	@Wire
	private Textbox id;
	@Wire
	private Textbox nombre;
	@Wire
	private Textbox ape1;
	@Wire
	private Textbox ape2;
	
	@Listen("onClick = #btnGuardar")
	public void grabar() throws Exception {
		String cadena;
		cadena = id.getText().trim();
		
		if(cadena.length() == 0) {
			throw new WrongValueException(id, "Error validando ID");
		}
		
		Profesor profesor = new Profesor();
		
		profesor.setId(Integer.parseInt(id.getText()));
		profesor.setNombre(nombre.getText());
		profesor.setApe1(ape1.getText());
		profesor.setApe2(ape2.getText());
		
		daoProfesor daoP = new daoProfesor();
		daoP.guardarProfesor(profesor);
		
		id.setText("");
		nombre.setText("");
		ape1.setText("");
		ape2.setText("");
		
		throw new WrongValueException(id, "Guardado exitoso");
	}
}
