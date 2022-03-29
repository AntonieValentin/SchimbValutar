import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Schimb{
	
private double coef;
BigDecimal val,inter;
JFrame frame = new JFrame();

Schimb(BigDecimal big, String moneda){
	if(moneda == "USD")
		coef = 0.2219756;
	if(moneda == "EUR")
		coef = 0.2020896;
	if(moneda == "GBP")
		coef = 0.1689674;
	if(moneda == "MXN")
		coef = 4.4464206;
	if(moneda == "CLF")
		coef = 0.005441;
	//val = big * coef;
	val = big.multiply(new BigDecimal(coef));
	val = val.setScale(2, BigDecimal.ROUND_HALF_UP);
	inter = val.divide(new BigDecimal(100));
	val= val.subtract(inter);
	JOptionPane.showMessageDialog(frame, "Pentru suma de " + big + " lei, veti primi " + val + " " + moneda);
}
	
	
}
