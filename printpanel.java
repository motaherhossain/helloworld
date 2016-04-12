import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import com.sun.java.swing.*;
import javax.swing.*;


public class printpanel extends JPanel implements ActionListener, Printable {

    public printpanel() {
	setBackground(Color.white);
        JButton b = new JButton("MyButton");
        b.addActionListener(this);
        add(b);

    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("action");
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        try { printJob.print(); } catch (Exception PrintException) { }
    }

       public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
            if (pi >= 1) {
                return Printable.NO_SUCH_PAGE;
            }

            g.translate(100, 100);
    	    Font  f = new Font("Monospaced",Font.PLAIN,12);
	    System.out.println (f);
	    g.setFont (f);
	    paint (g);
            return Printable.PAGE_EXISTS;
	}


    public static void main(String s[]) {
	WindowListener l = new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	};
	Frame f = new Frame("printbutton");
	f.addWindowListener(l);
	f.add("Center", new printpanel());
	f.pack();
	f.setSize(new Dimension(400,300));
	f.show();
    }
}

