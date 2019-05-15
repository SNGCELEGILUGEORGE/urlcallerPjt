
import java.awt.Desktop;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Insert extends javax.swing.JFrame   {

    JTextField txtget;
    JTextArea tal;
    JButton btn1; 
    
    public Insert() {
      
        initComponents();
      setLayout(null);
      txturlid.setVisible(false);
      txtinsid.setVisible(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setLocationRelativeTo(null);
      setSize(500,200);
    }
 public void theQuery(String query){
        
    Connection cn=null;
    Statement st=null;
    try{
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=urlcaller_db;user=root;password=root;");            
         st=cn.createStatement();
         st.executeUpdate(query);
         JOptionPane.showMessageDialog(null,"query executed");
    }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.getMessage());
        
    }   
    
    } 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_request = new javax.swing.JButton();
        txtGet = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtinsid = new javax.swing.JTextField();
        txturlid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_request.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_request.setText("Request");
        btn_request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestActionPerformed(evt);
            }
        });

        txtGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGetActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea);

        txtinsid.setEnabled(false);

        txturlid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(txtinsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(txturlid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGet, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btn_request, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtGet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(btn_request, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtinsid, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txturlid, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void btn_requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestActionPerformed

        
        java.util.Date date1=new java.util.Date();
        DateFormat timeFormat1=new SimpleDateFormat("dd/MM/yyyy");
        String sdate=timeFormat1.format(date1);  
         

        String txtValue = txtGet.getText();
        Integer  status=0;
        
        JOptionPane.showMessageDialog(null, txtValue);
       
         Connection cn=null;
        Statement st=null;
         try
         {
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=urlcaller_db;user=root;password=root");            
         st=cn.createStatement();         
         System.out.println("connected");
         String q1 = "select * from tbl_url where DATA='"+txtValue+"'";    
      
         ResultSet rs = st.executeQuery(q1); 
          if (!rs.isBeforeFirst() ){
        JOptionPane.showMessageDialog(null, "No corresponding Urls are available");
   }
          
       
         while(rs.next()) 
         { 
            String dataUrl=rs.getString("URL"); 
            txtArea.setText(dataUrl);
             String urlid=rs.getString("URLID");
            txturlid.setText(urlid);
            
         }
    
           {
               theQuery("insert into tbl_insresponse(insdata,insdate,status) values('"+txtValue+"','"+sdate+"','"+status+"')");
           }
         
         }
         catch(Exception exp){
            JOptionPane.showMessageDialog(null,exp.getMessage());
         }
        
 String q2 = "select insid,insdate from tbl_insresponse";    
      
        // Statement st=null;
         ResultSet rs = null; 
        try {
            rs = st.executeQuery(q2);
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()) 
           { 
              String rid=rs.getString("insid"); 
              txtinsid.setText(rid);
             String indate=rs.getString("insdate");
          
           }
        
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_btn_requestActionPerformed

    private void txtGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetActionPerformed

    private void txtAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAreaMouseClicked
       
        Connection cn=null;
        Statement st=null;
     
        try {
            String a="http://localhost:8080/";//WebApplication1/home.jsp          
       
        String txtValue = txtGet.getText();
        String txtVal=txtArea.getText();
        
         
        String ur=a+txtVal;
       
        String urlid=txturlid.getText();
        String resid=txtinsid.getText();
        
          java.util.Date date2=new java.util.Date();
        DateFormat timeFormat2=new SimpleDateFormat("dd/MM/yyyy");
        String rdate=timeFormat2.format(date2);  
        
            URL url = new URL(ur);
            System.out.println(url);
            Desktop d=Desktop.getDesktop();
            d.browse(new URI(ur));
            
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();

            int httpStatusCode = connection.getResponseCode(); //200, 404 etc.            
            System.out.println(httpStatusCode);
          //  if(txtVal==null)
          //  {
         //         txtArea.setText("no urls available"); 
         //   }
            if(httpStatusCode==200)
            {
            //theQuery("update tbl_insresponse set status=1 where insdata='(select insdata from tbl_insresponse order by id asc)'");
         theQuery("insert into tbl_response(RESPONSE_DATE,insid,URLID) values('"+rdate+"','" + resid +"','"+urlid+"')");
         
            }
           
            if(httpStatusCode==200)
            {
                theQuery("update tbl_insresponse set status=1 where insid=(select MAX(insid) from tbl_insresponse)");
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtAreaMouseClicked

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
       
      new Insert();
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_request;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtGet;
    private javax.swing.JTextField txtinsid;
    private javax.swing.JTextField txturlid;
    // End of variables declaration//GEN-END:variables

   
}
