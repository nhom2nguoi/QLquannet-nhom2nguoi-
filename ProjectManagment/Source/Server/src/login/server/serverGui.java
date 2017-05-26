/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csmserver;

import Action.CsmConnection;
import Action.SetTime;
import command.Commands;
import database.ConnectSqlServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import structure.Global;
import structure.MyProcess;
import structure.define;

/**
 *
 * @author Mr.Tran
 */
public class CsmserverGui extends javax.swing.JFrame {

    /**
     * Creates new form CsmserverGui
     */
    private long                    start;
    private int                     row = -1;
    private String                  iprow = "#";
    private String                  state = "#";
    public  DefaultTableModel       tableModel;
    private BufferedReader          reader;
    private PrintWriter             writer;
    public CsmserverGui() {
        
        initComponents();
        
        main_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = main_table.getSelectedRow();
                iprow = (String) main_table.getValueAt(row, 1);
                state = (String) main_table.getValueAt(row, 2);
                
                if(state == null)
                {
                    state = "#";
                }
            }
        });
        
        for(int i=0; i<5; i++)
        {
            String tenmay = "May "+(i+1);
            main_table.setValueAt(tenmay, i, 0);
            main_table.setValueAt(define.DISCONNECT, i, 2);
        }
        
        CsmConnection connection = new CsmConnection();
        connection.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPane = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        main_table = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        MoneyButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        ShutdownButton = new javax.swing.JButton();
        RestartButton = new javax.swing.JButton();
        DesktopButton = new javax.swing.JButton();
        HistoryButton = new javax.swing.JButton();
        AppsButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_fullname = new javax.swing.JTextField();
        txt_cmnd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btRegister = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_retype = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CSM SERVER");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(700, 375));

        main_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên máy", "Địa chỉ IP", "Trạng thái", "Tên người dùng", "Bắt đầu lúc", "Thời gian sử dụng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        main_table.setPreferredSize(new java.awt.Dimension(600, 300));
        jScrollPane3.setViewportView(main_table);

        jToolBar1.setRollover(true);
        jToolBar1.setEnabled(false);

        MoneyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/currency_dollar_red.png"))); // NOI18N
        MoneyButton.setText("Tính tiền");
        MoneyButton.setFocusable(false);
        MoneyButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MoneyButton.setInheritsPopupMenu(true);
        MoneyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MoneyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoneyButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(MoneyButton);

        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/door-in-icon.png"))); // NOI18N
        LoginButton.setText("Đăng Nhập");
        LoginButton.setFocusable(false);
        LoginButton.setHideActionText(true);
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LoginButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(LoginButton);

        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/door-out-icon.png"))); // NOI18N
        LogoutButton.setText("Đăng Xuất");
        LogoutButton.setFocusable(false);
        LogoutButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LogoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LogoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(LogoutButton);

        ShutdownButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/shutdown-icon.png"))); // NOI18N
        ShutdownButton.setText("Shutdown");
        ShutdownButton.setFocusable(false);
        ShutdownButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ShutdownButton.setInheritsPopupMenu(true);
        ShutdownButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ShutdownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShutdownButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ShutdownButton);

        RestartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/NX1-Restart-icon.png"))); // NOI18N
        RestartButton.setText("Restart");
        RestartButton.setFocusable(false);
        RestartButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RestartButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(RestartButton);

        DesktopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/monitor-desktop-icon.png"))); // NOI18N
        DesktopButton.setText("Desktop");
        DesktopButton.setFocusable(false);
        DesktopButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DesktopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DesktopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesktopButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(DesktopButton);

        HistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Browser-icon.png"))); // NOI18N
        HistoryButton.setText("Lịch sử trình duyệt");
        HistoryButton.setFocusable(false);
        HistoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        HistoryButton.setInheritsPopupMenu(true);
        HistoryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(HistoryButton);

        AppsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Apps-system-software-update-icon.png"))); // NOI18N
        AppsButton.setText("Ứng dụng");
        AppsButton.setFocusable(false);
        AppsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AppsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AppsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(AppsButton);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );

        TabPane.addTab("Chức năng", jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đăng ký"));

        jLabel1.setText("Tên đăng nhập");

        txt_username.setPreferredSize(new java.awt.Dimension(120, 20));

        txt_fullname.setPreferredSize(new java.awt.Dimension(120, 20));

        txt_cmnd.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel2.setText("Mật khẩu");

        jLabel3.setText("Nhập lại mật khẩu");

        jLabel4.setText("Họ và Tên");

        jLabel5.setText("CMND");

        btRegister.setText("Đăng ký");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });

        txt_password.setPreferredSize(new java.awt.Dimension(120, 20));

        txt_retype.setPreferredSize(new java.awt.Dimension(120, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_retype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btRegister)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_retype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btRegister)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        TabPane.addTab("Đăng ký", jPanel4);

        jMenu1.setText("File");
        jMenu1.setFocusable(false);

        jMenuItem1.setText("Exit");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TabPane.getAccessibleContext().setAccessibleName("Function");
        TabPane.getAccessibleContext().setAccessibleDescription("Function");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        MouseClick();
        
        if(state.equals(define.ONLINE))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);
                Commands cmd = new Commands(socket);
                boolean flag = cmd.LogoutButton();
                if(flag == true)
                {
                    main_table.setValueAt(define.OFFLINE, row, 2);  //Trang thai OFFLINE
                    main_table.setValueAt("", row, 3);  //Ten nguoi dung
                    main_table.setValueAt("", row, 4);  //bắt đầu lúc
                    
                    if(Global.threadtime != null)
                    {
                        Global.threadtime.stop();
                        Global.threadtime = null;
                    }
                    main_table.setValueAt("", row, 5);  //thoi gian su dung
                    
                    JOptionPane.showMessageDialog(null, "Đăng xuất thành công :D");
                }

                socket.close();
            }catch(IOException ex){
            }
        }
        else
        {
            if(state.equals(define.DISCONNECT)) //state = DISCONNECT
            {
                JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
            }
            else    // State = ONLINE
            {
                if(state.equals(define.OFFLINE))
                {
                    JOptionPane.showMessageDialog(null, "Máy đã đăng xuất.");
                }
                else    // state = null
                {
                    JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
                }
            }
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void ShutdownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShutdownButtonActionPerformed
        // TODO add your handling code here:
        MouseClick();
        
        if(!state.equals(define.DISCONNECT))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);
                Commands cmd = new Commands(socket);
                boolean flag = cmd.ShutdownButton();
                if(flag == true)
                {
                    main_table.setValueAt(define.DISCONNECT, row, 2);  //Trang thai ONLINE
                    main_table.setValueAt("", row, 3);  //Ten nguoi dung
                    main_table.setValueAt("", row, 4);  //bắt đầu lúc
                    main_table.setValueAt("", row, 5);  //đã dùng
                    
                    JOptionPane.showMessageDialog(null, "Tắt máy thành công :D");
                }

                socket.close();
            }catch(IOException ex){
            }
        }
        else // State = DISCONNECT
        {
            if(state.equals(define.DISCONNECT))
            {
                JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
            }
        }
    }//GEN-LAST:event_ShutdownButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        MouseClick();
        
        if(state.equals(define.OFFLINE))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);
                Commands cmd = new Commands(socket);
                boolean flag = cmd.LoginButton();
                if(flag == true)
                {
                    Calendar startCal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String startTime = sdf.format(startCal.getTime());
                    start = startCal.getTimeInMillis();
                    
                    main_table.setValueAt(define.ONLINE, row, 2);  //Trang thai ONLINE
                    main_table.setValueAt("ADMIN", row, 3);  //Ten nguoi dung
                    main_table.setValueAt(startTime, row, 4);  //bắt đầu lúc
                    
                    SetTime settime = new SetTime(start, row);
                    settime.start();
                    Global.threadtime = settime;
                    
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công :D");
                }

                socket.close();
            }catch(IOException ex){
            }
        }
        else
        {
            if(state.equals(define.DISCONNECT)) //state = DISCONNECT
            {
                JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
            }
            else    // State = ONLINE
            {
                if(state.equals(define.ONLINE))
                {
                    JOptionPane.showMessageDialog(null, "Máy đã đăng Nhập.");
                }
                else    // state = null
                {
                    JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
                }
            }
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        // TODO add your handling code here:
        //MouseClick();
                
        if(!state.equals(define.DISCONNECT))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);
                Commands cmd = new Commands(socket);
                boolean flag = cmd.RestartButton();
                if(flag == true)
                {
                    main_table.setValueAt(define.DISCONNECT, row, 2);  //Trang thai ONLINE
                    main_table.setValueAt("", row, 3);  //Ten nguoi dung
                    main_table.setValueAt("", row, 4);  //bắt đầu lúc
                    main_table.setValueAt("", row, 5);  //đã dùng
                    
                    JOptionPane.showMessageDialog(null, "Restart máy thành công :D");
                }

                //socket.close();
            }catch(IOException ex){
            }
        }
        else // State = DISCONNECT
        {
            
            if(state.equals(define.DISCONNECT))
            {
                JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
            }
        }
        
    }//GEN-LAST:event_RestartButtonActionPerformed

    private void DesktopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesktopButtonActionPerformed
        // TODO add your handling code here:
        //MouseClick();
        
        if(state.equals(define.ONLINE))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);

                Commands cmd = new Commands(socket);
                boolean flag = cmd.DesktopButton();

                if(flag == true)
                {
                    System.out.println("Remote cmd send client success.");
                }
                else
                {
                    System.out.println("Remote cmd send client fail.");
                }
                
                socket.close();
            }catch(IOException ex){
            }
        }
        else
        {
            if(state.equals(define.OFFLINE))
            {
                JOptionPane.showMessageDialog(null, "Máy chưa đăng nhập.");
            }
            else
            {
                if(state.equals(define.DISCONNECT))
                {
                    JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
                }
            }
        }
    }//GEN-LAST:event_DesktopButtonActionPerformed

    private void MoneyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoneyButtonActionPerformed
        // TODO add your handling code here:
        
        MouseClick();
        if(state.equals(define.ONLINE))
        {
            Calendar endCal = Calendar.getInstance();
            long end = endCal.getTimeInMillis();
            
            int minute = (int) ((end - start)/1000/60);
            int monney = minute*50;
            
            JOptionPane.showMessageDialog(null, monney);
            
            //start = 0;
        }
        else
        {
            if(state.equals(define.OFFLINE))
            {
                JOptionPane.showMessageDialog(null, "Máy chưa đăng nhập.");
            }
            else
            {
                if(state.equals(define.DISCONNECT))
                {
                    JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
                }
            }
        }
        
    }//GEN-LAST:event_MoneyButtonActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        // TODO add your handling code here:
        String username = txt_username.getText();
        
        char[] char1 = txt_password.getPassword();
        String password = new String(char1);
        
        char[] char2 = txt_retype.getPassword();
        String retype = new String(char2);
        
        String fullname = txt_fullname.getText();
        String cmnd = txt_cmnd.getText();
        
        if(username.equals("") || password.equals("") || retype.equals("") || fullname.equals("") || cmnd.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Phải điền vào tất cả các ô.");
        }
        else
        {
            if(!password.equals(retype))
            {
                JOptionPane.showMessageDialog(null, "Nhập lại password không chính xác.");
            }
            else
            {
                try {
                    ConnectSqlServer conn = new ConnectSqlServer();
                    Connection connection = conn.getConnetion();
                    Statement statement = connection.createStatement();
                    
                    String sql = String.format("INSERT INTO account (username, password, Hoten, CMND) VALUES ('%s', '%s', '%s', '%s')"
                            , username, password, fullname, cmnd);
                    
                    int n = statement.executeUpdate(sql);
                    if(n>0)
                    {
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công.");
                        
                        txt_username.setText("");
                        txt_password.setText("");
                        txt_retype.setText("");
                        txt_fullname.setText("");
                        txt_cmnd.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Đăng ký không thành công.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Đăng ký không thành công.");
                }
            }
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private void AppsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppsButtonActionPerformed
        // TODO add your handling code here:
        MouseClick();
        if(state.equals(define.ONLINE))
        {
            Socket socket = null;
            try
            {
                InetAddress ipclient = InetAddress.getByName(iprow);
                socket = new Socket(ipclient, define.CMD_CLIENT_PORT);

                Commands cmd = new Commands(socket);
                Vector<MyProcess> flag = cmd.AppsButton();

                if(flag != null)
                {
                    System.out.println("APPS cmd send client success.");
                    
                    ProcessListGui procListGui = new ProcessListGui(ipclient, flag);
                    procListGui.setVisible(true);
                    
                }
                else
                {
                    System.out.println("Remote cmd send client fail.");
                }
                
                socket.close();
            }catch(IOException ex){
            }
        }
        else
        {
            if(state.equals(define.OFFLINE))
            {
                JOptionPane.showMessageDialog(null, "Máy chưa đăng nhập.");
            }
            else
            {
                if(state.equals(define.DISCONNECT))
                {
                    JOptionPane.showMessageDialog(null, "Máy đã ngắt kết nối.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Chọn máy tính để thực hiện chức năng này.");
                }
            }
        }
        
    }//GEN-LAST:event_AppsButtonActionPerformed

    
    private void MouseClick()
    {
        row = main_table.getSelectedRow();
        iprow = (String) main_table.getValueAt(row, 1);
        state = (String) main_table.getValueAt(row, 2);

        if(state == null)
        {
            state = "#";
        }
        /*
        main_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = main_table.getSelectedRow();
                iprow = (String) main_table.getValueAt(row, 1);
                state = (String) main_table.getValueAt(row, 2);
                
                if(state == null)
                {
                    state = "#";
                }
            }
        });
        */
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         * Nimbus
         */
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
            //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CsmserverGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CsmserverGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CsmserverGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CsmserverGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CsmserverGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AppsButton;
    private javax.swing.JButton DesktopButton;
    private javax.swing.JButton HistoryButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton MoneyButton;
    private javax.swing.JButton RestartButton;
    private javax.swing.JButton ShutdownButton;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JButton btRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTable main_table;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_retype;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
