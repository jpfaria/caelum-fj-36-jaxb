package br.com.caelum.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshal {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setTitulo("Arquitetura Java");
		livro.setNomeAutor("Paulo Silveira");
		livro.setValor(new BigDecimal("29.90"));
		
		Categoria categoria = new Categoria();
		categoria.setNome("TI");
		
		livro.setCategoria(categoria);
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(livro, new FileOutputStream("livro.xml"));
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
	}

}
