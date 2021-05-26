package kodlamaio.HRMS.Adapter.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.HRMS.Adapter.abstracts.MernisService;
import kodlamaio.HRMS.entities.concretes.UserAccount;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisManager implements MernisService{

	@Override
	public boolean checkIfRealPerson(UserAccount userAccount) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(Long.valueOf(userAccount.getNationalityId()), userAccount.getFistName().toUpperCase(), userAccount.getLastName().toUpperCase(), userAccount.getDateOfBirth().getYear());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
				
				
	}

}
