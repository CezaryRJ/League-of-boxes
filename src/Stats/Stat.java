package Stats;

public class Stat implements StatInterface {
	protected double stat;
	protected int id;
	protected String type;

	@Override
	public double getvalue() {
		// TODO Auto-generated method stub
		return stat;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void settid(int id) {
		this.id = id;
	}
	public String gettype(){
		return type;
	}

	@Override
	public void setvalue(double a ) {
		// TODO Auto-generated method stub
		stat = a;
	}

}
