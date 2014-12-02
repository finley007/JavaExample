package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxb.Customer;

public class JAXBExample {

	public static void main(String[] args) {
//		createCustomerXML();
		createUserXML();
		
	}

	private static void createUserXML() {
		User user = new User();
		byte id = 1;
		user.setUId(id);
		toXML(user);
	}

	private static void createCustomerXML() {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);
		toXML(customer);
	}

	private static void toXML(Object obj) {
		try {
			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(obj, file);
			jaxbMarshaller.marshal(obj, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
