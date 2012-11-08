import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class Good extends JPanel {
	Random rand = new Random();
	
	private Planet planet;
	private Market market;
	private Transaction trans;
	private String name;
	private JLabel nameLabel, priceLabel, quantityLabel;
	private JButton plus, minus;
	private int price, quantity;

	private final int MTLP, MTLU, TTP, BP, IPL, VAR, MTL, MTH;

	public Good(Planet planet, final Market market, final Transaction trans, final String name, int MTLP, 
			int MTLU, int TTP, int BP, int IPL, int VAR, int MTL, int MTH) {
		this.planet = planet;
		this.market = market;
		this.trans = trans;

		this.name = name;
		this.MTLP = MTLP;
		this.MTLU = MTLU;
		this.TTP = TTP;
		this.BP = BP;
		this.IPL = IPL;
		this.VAR = VAR;
		this.MTL = MTL;
		this.MTH = MTH;

		nameLabel = new JLabel(name);

		quantity = 0;

		price = price();
		priceLabel = new JLabel("$" + price);
		quantityLabel = new JLabel("0");

		plus = new JButton("+");
		minus = new JButton("-");

		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(market.buy())
					quantityLabel.setText("" + trans.add(name, getBuyPrice()));
				else
					quantityLabel.setText("" + (-1*trans.add(name, getSellPrice())));
			}
		});

		minus.addActionListener(new ActionListener() {
			public void	actionPerformed(ActionEvent e) {
				if(market.buy())
					quantityLabel.setText("" + trans.remove(name, getBuyPrice()));
				else
					quantityLabel.setText("" + (-1*trans.remove(name, getSellPrice())));
			}
		});

		setPreferredSize(new Dimension(518, 40));

		add(nameLabel);
		add(priceLabel);
		add(quantityLabel);

		add(plus);
		add(minus);
	}

	private int price() {
		return (BP + (IPL*(planet.getTechLevel() - MTLP)) + (rand.nextInt(2*VAR-1)-VAR));
	}

	public int getBuyPrice() {
		return price;
	}
	
	public int getSellPrice() {
		return (int)(price*0.75);
	}

	public void disable() {
		plus.setEnabled(false);
		minus.setEnabled(false);
	}

	public void reset(Transaction trans) {
		this.trans = trans;
		quantity = 0;
		quantityLabel.setText(quantity + "");
	}
}
