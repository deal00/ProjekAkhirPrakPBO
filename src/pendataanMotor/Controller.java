package pendataanMotor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Lenovo
 */
public class Controller {
    Model modelPendataan;
    View viewPendataan;
    public String data;
    public Controller(Model modelPendataan, View viewPendataan){
        this.modelPendataan = modelPendataan;
        this.viewPendataan = viewPendataan;
        
        if (modelPendataan.getBanyakData()!=0) {
            String dataPembelian[][] = modelPendataan.readData();
            viewPendataan.tabel.setModel((new JTable(dataPembelian, viewPendataan.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
         viewPendataan.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nik = viewPendataan.getNIK();
                String Nama = viewPendataan.getnama();
                String tipeMotor = viewPendataan.gettipe();
                String Tanggal = viewPendataan.gettanggal();
                if(nik.isEmpty() || Nama.isEmpty() || viewPendataan.gettipe().isEmpty() || Tanggal.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }else{
                    String merek = viewPendataan.getmerek();
                    modelPendataan.insertData(nik, Nama, tipeMotor, merek, Tanggal);
                }
                
         
                String dataPembelian[][] = modelPendataan.readData();
                viewPendataan.tabel.setModel((new JTable(dataPembelian, viewPendataan.namaKolom)).getModel());
            }
        });
         
          viewPendataan.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String nik = viewPendataan.getNIK();
                String Nama = viewPendataan.getnama();
                String tipe = viewPendataan.gettipe();
                String tipeMotor = viewPendataan.getmerek();
                String Tanggal = viewPendataan.gettanggal();
                modelPendataan.updateData(nik, Nama, tipe, tipeMotor, Tanggal);
                String dataPembelian[][] = modelPendataan.readData();
                viewPendataan.tabel.setModel((new JTable(dataPembelian, viewPendataan.namaKolom)).getModel());
            }
        });
         
          viewPendataan.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                viewPendataan.tfnik.setText("");
                viewPendataan.tfNama.setText("");
                viewPendataan.tfTipe.setText("");
                viewPendataan.tftanggal.setText("");
            }
        });
        
    
          viewPendataan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = viewPendataan.tabel.getSelectedRow();
                data = viewPendataan.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewPendataan.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewPendataan.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
            }
           });
                  
          viewPendataan.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus nik " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                modelPendataan.deleteData(data);
                String dataPembelian[][] = modelPendataan.readData();
                viewPendataan.tabel.setModel((new JTable(dataPembelian, viewPendataan.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });
    }
}
