package pendataanMotor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lenovo
 */
public class View extends JFrame{
    JLabel lnik = new JLabel("NIK");
    JLabel lnama = new JLabel("Nama");
    JLabel lTipe = new JLabel("Tipe");
    JLabel lMerek = new JLabel("Merek Motor");
    JLabel lTanggal = new JLabel("Tanggal");
    
    public JTextField tfnik = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfTipe = new JTextField();
    String [] Merek = {"Yamaha", "Honda", "Suzuki", "Kawasaki", "KTM", "Ducati"};
    public JComboBox MerekMotor = new JComboBox(Merek);
    public JTextField tftanggal = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NIK", "Nama", "Tipe", "Merek Motor", "Tanggal"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Pencatatan Penjualan Motor Di Badhil Motors");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(900,600);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 630, 450);
        
        add(lnik);
        lnik.setBounds(670, 20, 90, 20);
        add(tfnik);
        tfnik.setBounds(670, 40, 120, 20);
        
        add(lnama);
        lnama.setBounds(670, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(670, 80, 120, 20);
        
        add(lTipe);
        lTipe.setBounds(670, 100, 90, 20);
        add(tfTipe);
        tfTipe.setBounds(670, 120, 120, 20);
        
        add(lMerek);
        lMerek.setBounds(670, 140, 90, 20);
        add(MerekMotor);
        MerekMotor.setBounds(670, 160, 120, 20);
        
        add(lTanggal);
        lTanggal.setBounds(670, 180, 90, 20);
        add(tftanggal);
        tftanggal.setBounds(670, 200, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(670, 230, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(670, 260, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(670, 290, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(670, 320, 90, 20);
    }
    
    public String getNIK(){
        return tfnik.getText();
    }
    
    public String getnama(){
        return tfNama.getText();
    }
    
    public String gettipe(){
        return tfTipe.getText();
    }
    
    public String getmerek(){
        return (String) MerekMotor.getSelectedItem();
    }
    
    public String gettanggal(){
        return tftanggal.getText();
    }
}
