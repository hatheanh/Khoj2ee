package chucnangqlkho;

public class Kho {
	private int id;
	private String tenkho;
	//private String tenhang;
	private String diadiem;

public Kho() {

}
public Kho(int _id) {
	id = _id;
}
public Kho(String _tenkho, String _diadiem) {
	tenkho = _tenkho;
	
	diadiem =_diadiem;
	//tenhang =_tenhang;
}

public Kho(int _id, String _tenkho, String _diadiem) {
	id = _id;
	tenkho = _tenkho;
	//tenhang = _tenhang;
	diadiem = _diadiem;
}

/*public void setTenhang(String tenhang) {
	this.tenhang = tenhang;
}*/

public void setId(int id) {
	this.id = id;
}
public void setTenkho(String tenkho) {
	this.tenkho = tenkho;
}

public void setDiadiem(String diadiem) {
	this.diadiem = diadiem;
}

/*public String getTenhang() {
	return tenhang;
}*/

public int getId() {
	return id;
}

public String getTenkho() {
	return tenkho;
}

public String getDiadiem() {
	return diadiem;
}
public void print() {
	System.out.println("ID: "+ id);
	System.out.println("Tenkho: "+ tenkho);
	//System.out.println("Tenhang: "+ tenhang);
	System.out.println("Diadiem: "+ diadiem);
	
}

}

