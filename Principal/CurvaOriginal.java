package principal;

import java.util.List;

import interfaz.BDConnection;

public class CurvaOriginal implements curva {
    private List<parIV> pts;
    
    private int idCurva;
	
	private String modName;
    
    private double Isc;
    private double Voc;
    private double Pmax;
    private double IPmax;
    private double VPmax;
    private double FF;
    
    private double temp;
    private double irr;
    
    private String fecha;

   public CurvaOriginal(double isc, double voc, double pmax,double ipmax, double vpmax, double ff, List<parIV> PTS,String date,double t,double i,String mod) throws ClassNotFoundException {

		this.fecha = date;
		this.FF = ff;
		this.Pmax=pmax;
		this.IPmax = ipmax;
		this.Isc = isc;
		this.pts = PTS;
		this.Voc = voc;
		this.VPmax = vpmax;
		this.temp = t;
		this.irr = i;
	   this.modName=mod;

		BDConnection baseDatos = new BDConnection();
		baseDatos.Insert("INSERT INTO CURVAORIGINAL VALUES("+nuevoID()+",'"+date+"',"+isc+","+voc+","+pmax+","+ipmax+","+vpmax+","+ff+","+t+","+i+",'"+mod+"');");

	}
    
    
    	public CurvaOriginal(int i) {
		// dado un id carga el objeto de la base de datos;
    	idCurva = i;
	}

    
	public double getTemp() {
		return temp;
	}


	public void setTemp(double temp) {
		this.temp = temp;
	}


	public double getIrr() {
		return irr;
	}


	public void setIrr(double irr) {
		this.irr = irr;
	}


	public List<parIV> getPts() {
		return pts;
	}

	public void setPts(List<parIV> pts) {
		this.pts = pts;
	}

	public double getIsc() {
		return Isc;
	}

	public void setIsc(double isc) {
		Isc = isc;
	}

	public double getVoc() {
		return Voc;
	}

	public void setVoc(double voc) {
		Voc = voc;
	}

	public double getPmax() {
		return Pmax;
	}

	public void setPmax(double pmax) {
		Pmax = pmax;
	}

	public double getIPmax() {
		return IPmax;
	}

	public void setIPmax(double iPmax) {
		IPmax = iPmax;
	}

	public double getVPmax() {
		return VPmax;
	}

	public void setVPmax(double vPmax) {
		VPmax = vPmax;
	}

	public double getFF() {
		return FF;
	}

	public void setFF(double fF) {
		FF = fF;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void mostrarDatos(){
        int i = 0;
        for (parIV p : pts){
            System.out.println("PARIV" + i + "[Intensidad = " + p.getIntensidad() + "] ; [Voltaje = " + p.getVoltaje() + "]");
            i++;
        }
    }


	public int getIdCurva() {
		return idCurva;
	}


	public void setIdCurva(int idCurva) {
		this.idCurva = idCurva;
	}
	
	private int nuevoID() throws ClassNotFoundException{
		BDConnection baseDatos = new BDConnection();
		List<Object[]> listaID = baseDatos.Select("SELECT IDCURVA FROM CURVAORIGINAL;");
		int max = 0;
		for(Object[] aux : listaID){
			if(max < (int) aux[0]){
				max = (int) aux[0];
			}
		}
		return (max+1);
	}
}

