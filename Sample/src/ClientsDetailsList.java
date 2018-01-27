import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClientsDetailsList {

	public List<ClientDetails> readFile() throws IOException {
		final String DELIMITER = "/";
		Scanner fileScan;
		String nxtLine;

		String clientID, title, initials, surname, street, town, postcode, policy;
		List<ClientDetails> clientDetailsList = new ArrayList<ClientDetails>();

		try {
			fileScan = new Scanner(new File("input.txt"));
			String[] clientData;

			while (fileScan.hasNext()) {
				nxtLine = fileScan.nextLine();

				clientData = nxtLine.split(DELIMITER);

				clientID = clientData[0];
				title = clientData[1];
				initials = clientData[2];
				surname = clientData[3];
				street = clientData[4];
				town = clientData[5];
				postcode = clientData[6];
				policy = clientData[7];

				ClientDetails cdetials = new ClientDetails(clientID);
				cdetials.setName(title + " " + initials + " " + surname);
				cdetials.setAddress(street + " " + town + " " + postcode);
				cdetials.setPolicy(policy);

				clientDetailsList.add(cdetials);
			}
			fileScan.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return clientDetailsList;
	}

	public static void main(String[] args) throws IOException {
		ClientsDetailsList cdl = new ClientsDetailsList();
		List<ClientDetails> cds = cdl.readFile();
		
		Iterator<ClientDetails> iter = cds.iterator();
		while(iter.hasNext()){
			ClientDetails cd = iter.next();
			System.out.print(cd.getClientId() + " ");
			System.out.print(cd.getName() + " ");
			System.out.print(cd.getAddress() + " ");
			System.out.print(cd.getPolicy() + " ");
			System.out.println();
		}
	}
}

class ClientDetails {
	String clientId;
	String name;
	String address;
	String policy;

	public ClientDetails(String clientID) {
		this.clientId = clientID;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}
}