package Users;

public class Medic extends UserWithTurns{

	public Medic(String user, String password) {super(user, password);}

	public boolean acceptPrepaid() {return false;}
}
