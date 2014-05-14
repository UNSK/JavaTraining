package ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *　名前と値をの組を保持する属性クラス
 */
public class Attr {
	private final String name;
	private Object value = null;
	
	/**
	 * @param name the name to set default
	 */
	public Attr(String name) {
		this.name = name;
	}
	
	/**
	 * @param name the name to default
	 * @param value the value to default
	 */
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @param file the data file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Attr(File file) throws IOException, ClassNotFoundException {
	    InputStream fin = new FileInputStream(file);
	    DataInputStream din = new DataInputStream(fin);
	    ObjectInputStream oin = new ObjectInputStream(fin);
	    
	    try {
	        this.name = din.readUTF();
	        this.value = oin.readObject();
	    } finally {
	        din.close();
	        oin.close();
	        fin.close();	    
	    }
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param newValue the value to set
	 * @return old value
	 */
	public Object setValue(Object newValue) {
		Object oldVal = value;
		this.value = newValue;
		return oldVal;
	}

	@Override
	public String toString() {
		return name + "='" + value + "'";
	}
	
	/**
	 * write data to a file
	 * @param filepath a file path you want to write in.
	 * @throws IOException
	 */
	public void writeData(String filepath) throws IOException {
	    OutputStream fout = new FileOutputStream(filepath);
	    DataOutputStream dout = new DataOutputStream(fout);
	    ObjectOutputStream oout = new ObjectOutputStream(fout);
	    try {
	        dout.writeUTF(name);
	        oout.writeObject(value);
	    } finally {
	        dout.close();
	        oout.close();
	        fout.close();
	    }
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	    final String filepath = "../ch20/src/ex20_07/test.attr";
	    
        Attr attr = new Attr("foo", new Integer(123));
        attr.writeData(filepath);
        
        Attr loadAttr = new Attr(new File(filepath));
        System.out.println(loadAttr);
    }
	
}
