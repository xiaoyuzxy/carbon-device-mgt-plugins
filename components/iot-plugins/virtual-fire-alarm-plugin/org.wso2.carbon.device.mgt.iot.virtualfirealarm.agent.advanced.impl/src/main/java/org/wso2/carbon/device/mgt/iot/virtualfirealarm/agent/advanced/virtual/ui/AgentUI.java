/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.iot.virtualfirealarm.agent.advanced.virtual.ui;

import org.wso2.carbon.device.mgt.iot.virtualfirealarm.agent.advanced.core.AgentConstants;
import org.wso2.carbon.device.mgt.iot.virtualfirealarm.agent.advanced.core.AgentManager;
import org.wso2.carbon.device.mgt.iot.virtualfirealarm.agent.advanced.core.AgentUtilOperations;
import org.wso2.carbon.device.mgt.iot.virtualfirealarm.agent.advanced.virtual.VirtualHardwareManager;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class AgentUI extends JFrame {

    private boolean isTemperatureRandomized, isHumidityRandomized;
    private boolean isTemperatureSmoothed, isHumiditySmoothed;

    private volatile boolean isAlarmOn = false;

    private final Object _lock = new Object();

    private JLabel picLabelBulbOn, picLabelBulbOff;

    private volatile java.util.List<String> policyLogs = new ArrayList<>();

    // Variables declaration - do not modify
    private JButton btnControl;
    private JButton btnView;
    private JCheckBox chkbxEmulate;
    private JCheckBox chkbxHumidityRandom;
    private JCheckBox chkbxHumiditySmooth;
    private JCheckBox chkbxTemperatureRandom;
    private JCheckBox chkbxTemperatureSmooth;
    private JComboBox cmbInterface;
    private JComboBox cmbPeriod;
    private JComboBox cmbProtocol;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator5;
    private JLabel lblAgentName;
    private JLabel lblStatus;
    private JPanel pnlBulbStatus;
    private JSpinner spinnerHumidity;
    private JSpinner spinnerInterval;
    private JSpinner spinnerTemperature;
	private JTextArea txtAreaLogs;
    private JTextField txtHumidityMax;
    private JTextField txtHumidityMin;
    private JTextField txtHumiditySVF;
    private JTextField txtTemperatureMax;
    private JTextField txtTemperatureMin;
    private JTextField txtTemperatureSVF;
    // End of variables declaration

    //Update UI from AgentManager changes
    private Runnable uiUpdater = new Runnable() {
        @Override
        public void run() {
            while (true) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        pnlBulbStatus.removeAll();
                        pnlBulbStatus.add(isAlarmOn ? picLabelBulbOn : picLabelBulbOff);
                        pnlBulbStatus.updateUI();
                        lblStatus.setText(AgentManager.getInstance().getAgentStatus());
                        String policy = getPolicyLog();
                        if (policy != null){
                            txtAreaLogs.append("\n" + policy);
	                        txtAreaLogs.append("\n--------------------------------------------------\n");
                        }
                        if (isTemperatureRandomized) {
                            txtTemperatureMinActionPerformed(null);
                            txtTemperatureMaxActionPerformed(null);
                            if (isTemperatureSmoothed) {
                                txtTemperatureSVFActionPerformed(null);
                            }
                        }
                        if (isHumidityRandomized) {
                            txtHumidityMinActionPerformed(null);
                            txtHumidityMaxActionPerformed(null);
                            if (isHumiditySmoothed) {
                                txtHumiditySVFActionPerformed(null);
                            }
                        }
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    /**
     * Creates new form AgentUI
     */
    public AgentUI() {
	    initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblAgentName = new JLabel();
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        pnlBulbStatus = new JPanel();
        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        chkbxTemperatureRandom = new JCheckBox();
        jSeparator1 = new JSeparator();
        jPanel7 = new JPanel();
        jLabel5 = new JLabel();
        txtTemperatureMin = new JTextField();
        jLabel6 = new JLabel();
        txtTemperatureMax = new JTextField();
        jLabel10 = new JLabel();
        txtTemperatureSVF = new JTextField();
        spinnerTemperature = new JSpinner();
        chkbxTemperatureSmooth = new JCheckBox();
        jPanel6 = new JPanel();
        jLabel20 = new JLabel();
        btnView = new JButton();
        btnControl = new JButton();
        lblStatus = new JLabel();
        jPanel8 = new JPanel();
        jLabel23 = new JLabel();
        chkbxHumidityRandom = new JCheckBox();
        jSeparator5 = new JSeparator();
        jPanel9 = new JPanel();
        jLabel24 = new JLabel();
        txtHumidityMin = new JTextField();
        jLabel25 = new JLabel();
        txtHumidityMax = new JTextField();
        txtHumiditySVF = new JTextField();
        jLabel11 = new JLabel();
        spinnerHumidity = new JSpinner();
        chkbxHumiditySmooth = new JCheckBox();
        jPanel3 = new JPanel();
        jLabel7 = new JLabel();
        spinnerInterval = new JSpinner();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        cmbProtocol = new JComboBox();
        jLabel12 = new JLabel();
        cmbInterface = new JComboBox();
        jScrollPane1 = new JScrollPane();
        txtAreaLogs = new JTextArea();
        jPanel4 = new JPanel();
        chkbxEmulate = new JCheckBox();
        cmbPeriod = new JComboBox();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fire Alarm Emulator");
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - 650 / 2, dim.height / 2 - 440 / 2);

        lblAgentName.setFont(new Font("Cantarell", 1, 24)); // NOI18N
        lblAgentName.setHorizontalAlignment(SwingConstants.LEFT);
        lblAgentName.setText("Device Name: " + AgentManager.getInstance().getDeviceName());

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Copyright (c) 2015, WSO2 Inc.");

        jPanel1.setBackground(new Color(220, 220, 220));

        jLabel3.setFont(new Font("Cantarell", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Alarm Status");

        pnlBulbStatus.setBackground(new Color(220, 220, 220));

        GroupLayout pnlBulbStatusLayout = new GroupLayout(pnlBulbStatus);
        pnlBulbStatus.setLayout(pnlBulbStatusLayout);
        pnlBulbStatusLayout.setHorizontalGroup(
                pnlBulbStatusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBulbStatusLayout.setVerticalGroup(
                pnlBulbStatusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 167, Short.MAX_VALUE)
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        GroupLayout.Alignment.TRAILING)
                                                  .addComponent(pnlBulbStatus,
                                                                GroupLayout
                                                                        .DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                  .addComponent(jLabel3,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                190, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(jLabel3)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(pnlBulbStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addContainerGap())
        );

        jPanel2.setBackground(new Color(220, 220, 220));

        jLabel4.setFont(new Font("Cantarell", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Temperature");

        chkbxTemperatureRandom.setText("Randomize Data");
        chkbxTemperatureRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxTemperatureRandomActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        jPanel7.setBackground(new Color(220, 220, 220));

        jLabel5.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel5.setText("Min");

        txtTemperatureMin.setHorizontalAlignment(JTextField.CENTER);
        txtTemperatureMin.setText("20");
        txtTemperatureMin.setEnabled(false);
        txtTemperatureMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperatureMinActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setText("Max");

        txtTemperatureMax.setHorizontalAlignment(JTextField.CENTER);
        txtTemperatureMax.setText("50");
        txtTemperatureMax.setEnabled(false);
        txtTemperatureMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperatureMaxActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel10.setText("SV %");

        txtTemperatureSVF.setHorizontalAlignment(JTextField.CENTER);
        txtTemperatureSVF.setText("50");
        txtTemperatureSVF.setEnabled(false);
        txtTemperatureSVF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperatureSVFActionPerformed(evt);
            }
        });

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                          .addComponent(jLabel5)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(txtTemperatureMin, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel6)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(txtTemperatureMax, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel10)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(txtTemperatureSVF, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                           Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout
                                .createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                 Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(
                                        GroupLayout.Alignment.BASELINE)
                                                  .addComponent(txtTemperatureMin,
                                                                GroupLayout
                                                                        .PREFERRED_SIZE,
                                                                GroupLayout
                                                                        .DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                  .addComponent(txtTemperatureMax,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                  .addComponent(jLabel6)
                                                  .addComponent(jLabel5)
                                                  .addComponent(jLabel10)
                                                  .addComponent(txtTemperatureSVF,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
        );

        spinnerTemperature.setFont(new Font("Cantarell", 1, 24)); // NOI18N
        spinnerTemperature.setModel(new SpinnerNumberModel(30, 0, 100, 1));
        spinnerTemperature.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTemperatureStateChanged(evt);
            }
        });

        chkbxTemperatureSmooth.setText("Smooth Variation");
        chkbxTemperatureSmooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxTemperatureSmoothActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(spinnerTemperature))
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                              .addComponent(chkbxTemperatureRandom)
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                              .addComponent(chkbxTemperatureSmooth)))
                                          .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(jSeparator1)
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                              .addGroup(jPanel2Layout.createParallelGroup(
                                                                                      GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(
                                                                                                        chkbxTemperatureRandom)
                                                                                                .addComponent(
                                                                                                        chkbxTemperatureSmooth))
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                              .addGap(0, 0, Short.MAX_VALUE))
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                              .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addComponent(spinnerTemperature)))
                                          .addContainerGap())
        );

        jPanel6.setBackground(new Color(253, 254, 209));

        jLabel20.setText("Connection Status:");
        jLabel20.setVerticalTextPosition(SwingConstants.TOP);

        btnView.setText("View Device Data");
        btnView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewMouseClicked(evt);
            }
        });

        btnControl.setText("Control Device");
        btnControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnControlMouseClicked(evt);
            }
        });

        lblStatus.setFont(new Font("Cantarell", 1, 15)); // NOI18N
        lblStatus.setText("Not Connected");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(jLabel20)
                                          .addPreferredGap(LayoutStyle
                                                                   .ComponentPlacement.RELATED)
                                          .addComponent(lblStatus, GroupLayout
                                                  .DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(btnControl)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(btnView)
                                          .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                 Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING, false)
                                                  .addComponent(jLabel20,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                  .addGroup(jPanel6Layout.createParallelGroup(
                                                          GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(btnView,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  Short.MAX_VALUE)
                                                                    .addComponent(btnControl)
                                                                    .addComponent(lblStatus)))
                                .addContainerGap())
        );

        jPanel8.setBackground(new Color(220, 220, 220));

        jLabel23.setFont(new Font("Cantarell", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel23.setText("Humidity");

        chkbxHumidityRandom.setText("Randomize Data");
        chkbxHumidityRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxHumidityRandomActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(SwingConstants.VERTICAL);

        jPanel9.setBackground(new Color(220, 220, 220));

        jLabel24.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel24.setText("Min");

        txtHumidityMin.setHorizontalAlignment(JTextField.CENTER);
        txtHumidityMin.setText("20");
        txtHumidityMin.setEnabled(false);
        txtHumidityMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHumidityMinActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel25.setText("Max");

        txtHumidityMax.setHorizontalAlignment(JTextField.CENTER);
        txtHumidityMax.setText("50");
        txtHumidityMax.setEnabled(false);
        txtHumidityMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHumidityMaxActionPerformed(evt);
            }
        });

        txtHumiditySVF.setHorizontalAlignment(JTextField.CENTER);
        txtHumiditySVF.setText("50");
        txtHumiditySVF.setEnabled(false);
        txtHumiditySVF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHumiditySVFActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setText("SV %");

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                          .addComponent(jLabel24)
                                          .addPreferredGap(LayoutStyle
                                                                   .ComponentPlacement.RELATED)
                                          .addComponent(txtHumidityMin, GroupLayout
                                                  .PREFERRED_SIZE, 45, GroupLayout
                                                  .PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle
                                                                   .ComponentPlacement.RELATED)
                                          .addComponent(jLabel25)
                                          .addPreferredGap(LayoutStyle
                                                                   .ComponentPlacement.RELATED)
                                          .addComponent(txtHumidityMax, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel11)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(txtHumiditySVF, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                 Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING)
                                                  .addGroup(jPanel9Layout.createParallelGroup(
                                                          GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel11)
                                                                    .addComponent(txtHumiditySVF,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(jPanel9Layout.createParallelGroup(
                                                          GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(txtHumidityMin,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(txtHumidityMax,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel25)
                                                                    .addComponent(jLabel24)))
                                .addGap(35, 35, 35))
        );

        spinnerHumidity.setFont(new Font("Cantarell", 1, 24)); // NOI18N
        spinnerHumidity.setModel(new SpinnerNumberModel(30, 0, 100, 1));
        spinnerHumidity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerHumidityStateChanged(evt);
            }
        });

        chkbxHumiditySmooth.setText("Smooth Variation");
        chkbxHumiditySmooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxHumiditySmoothActionPerformed(evt);
            }
        });

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(spinnerHumidity))
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                                              .addComponent(chkbxHumidityRandom)
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                              .addComponent(chkbxHumiditySmooth)))
                                          .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(jSeparator5)
                                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                                              .addGroup(jPanel8Layout.createParallelGroup(
                                                                                      GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(
                                                                                                        chkbxHumidityRandom)
                                                                                                .addComponent(
                                                                                                        chkbxHumiditySmooth))
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                              .addGap(0, 1, Short.MAX_VALUE))
                                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                                              .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                                              .addPreferredGap
                                                                                      (LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addComponent
                                                                                      (spinnerHumidity)))
                                          .addContainerGap())
        );

        jPanel3.setBackground(new Color(207, 233, 234));

        jLabel7.setText("Data Push Interval:");

        spinnerInterval.setModel(new SpinnerNumberModel(Integer.valueOf(5), Integer
                .valueOf(1), null, Integer.valueOf(1)));
        spinnerInterval.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerIntervalStateChanged(evt);
            }
        });

        jLabel8.setText("Seconds");

        jLabel9.setText("Protocol:");

        cmbProtocol.setModel(new DefaultComboBoxModel(new String[] { "MQTT", "XMPP",
                "HTTP" }));
        cmbProtocol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProtocolActionPerformed(evt);
            }
        });

        jLabel12.setText("Interface:");

        cmbInterface.setModel(new DefaultComboBoxModel(new String[] { "eth0" }));
        cmbInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInterfaceActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(jLabel7)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(spinnerInterval, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel8)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jLabel12)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(cmbInterface, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel9)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(cmbProtocol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout
                                .createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                 Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING)
                                                  .addGroup(jPanel3Layout.createParallelGroup(
                                                          GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel12)
                                                                    .addComponent(cmbInterface,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(jPanel3Layout.createParallelGroup(
                                                          GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel7)
                                                                    .addComponent(spinnerInterval,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel8)
                                                                    .addComponent(jLabel9)
                                                                    .addComponent(cmbProtocol,
                                                                                  GroupLayout.PREFERRED_SIZE,
                                                                                  GroupLayout.DEFAULT_SIZE,
                                                                                  GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        txtAreaLogs.setBackground(new Color(1, 1, 1));
        txtAreaLogs.setColumns(20);
	    txtAreaLogs.setFont(new Font("Courier 10 Pitch", Font.BOLD, 9)); // NOI18N
        txtAreaLogs.setForeground(new Color(0, 255, 0));
        txtAreaLogs.setRows(5);
        jScrollPane1.setViewportView(txtAreaLogs);

        jPanel4.setBackground(new Color(169, 253, 173));

        chkbxEmulate.setText("Emulate data");
        chkbxEmulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxEmulateActionPerformed(evt);
            }
        });

        cmbPeriod.setModel(new DefaultComboBoxModel(new String[] { "1 hour", "1 day", "1 week", "1 month " }));
        cmbPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPeriodActionPerformed(evt);
            }
        });

        jLabel1.setText("Emulation Period");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(chkbxEmulate)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jLabel1)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(cmbPeriod, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                 Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(
                                        GroupLayout.Alignment.BASELINE)
                                                  .addComponent(chkbxEmulate)
                                                  .addComponent(cmbPeriod,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE)
                                                  .addComponent(jLabel1))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(jScrollPane1)
                                                            .addComponent(lblAgentName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(layout.createSequentialGroup()
                                                                              .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addGroup(layout.createParallelGroup(
                                                                                      GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(
                                                                                                        jPanel8,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE)
                                                                                                .addComponent(
                                                                                                        jPanel2,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE)))
                                                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                          .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                          .addComponent(lblAgentName, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                              .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                              .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
        );

        pack();

        chkbxTemperatureSmooth.setEnabled(false);
        chkbxTemperatureSmooth.setEnabled(false);

        cmbInterface.removeAllItems();
        for (String item : AgentManager.getInstance().getInterfaceList()){
            cmbInterface.addItem(item);
        }
        cmbInterface.setEnabled(false);

        cmbProtocol.removeAllItems();
        for (String item : AgentManager.getInstance().getProtocolList()){
            cmbProtocol.addItem(item);
        }
        cmbProtocol.setSelectedItem(AgentConstants.DEFAULT_PROTOCOL);

        URL urlAlarmOn = this.getClass().getResource("/alarm-on.gif");
        ImageIcon imageIconAlarmOn = new ImageIcon(urlAlarmOn);

        URL urlAlarmOff = this.getClass().getResource("/alarm-off.gif");
        ImageIcon imageIconAlarmOff = new ImageIcon(urlAlarmOff);

        picLabelBulbOn = new JLabel(imageIconAlarmOn);
        picLabelBulbOn.setSize(pnlBulbStatus.getSize());

        picLabelBulbOff = new JLabel(imageIconAlarmOff);
        picLabelBulbOff.setSize(pnlBulbStatus.getSize());

        addToPolicyLog(AgentUtilOperations.formatMessage(AgentManager.getInstance().getInitialPolicy()));
        new Thread(uiUpdater).start();

	    AgentManager.getInstance().setDeviceReady(true);
    }

    private void btnControlMouseClicked(java.awt.event.MouseEvent evt) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI uri = new URI(AgentManager.getInstance().getDeviceMgtControlUrl());
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void btnViewMouseClicked(java.awt.event.MouseEvent evt) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI uri = new URI(AgentManager.getInstance().getDeviceMgtAnalyticUrl());
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void chkbxTemperatureRandomActionPerformed(java.awt.event.ActionEvent evt) {
        isTemperatureRandomized = chkbxTemperatureRandom.isSelected();
        VirtualHardwareManager.getInstance().setIsTemperatureRandomized(isTemperatureRandomized);
        spinnerTemperature.setEnabled(!isTemperatureRandomized);
        txtTemperatureMax.setEnabled(isTemperatureRandomized);
        txtTemperatureMin.setEnabled(isTemperatureRandomized);
        chkbxTemperatureSmooth.setEnabled(isTemperatureRandomized);
        txtTemperatureSVF.setEnabled(isTemperatureRandomized && isTemperatureSmoothed);
    }

    private void chkbxHumidityRandomActionPerformed(java.awt.event.ActionEvent evt) {
        isHumidityRandomized = chkbxHumidityRandom.isSelected();
        VirtualHardwareManager.getInstance().setIsHumidityRandomized(isHumidityRandomized);
        spinnerHumidity.setEnabled(!isHumidityRandomized);
        txtHumidityMax.setEnabled(isHumidityRandomized);
        txtHumidityMin.setEnabled(isHumidityRandomized);
        chkbxHumiditySmooth.setEnabled(isHumidityRandomized);
        txtTemperatureSVF.setEnabled(isHumidityRandomized && isHumiditySmoothed);
    }

    private void spinnerTemperatureStateChanged(javax.swing.event.ChangeEvent evt) {
        if (!isTemperatureRandomized) {
            try {
                int temperature = Integer.parseInt(spinnerTemperature.getValue().toString());
                VirtualHardwareManager.getInstance().setTemperature(temperature);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid temperature value", "Error", JOptionPane.ERROR_MESSAGE);
                spinnerTemperature.setValue(VirtualHardwareManager.getInstance().getTemperature());
            }
        }
    }

    private void spinnerHumidityStateChanged(javax.swing.event.ChangeEvent evt) {
        if (!isHumidityRandomized) {
            try {
                int humidity = Integer.parseInt(spinnerHumidity.getValue().toString());
                VirtualHardwareManager.getInstance().setHumidity(humidity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid humidity value", "Error", JOptionPane.ERROR_MESSAGE);
                spinnerHumidity.setValue(VirtualHardwareManager.getInstance().getHumidity());
            }
        }
    }

    private void txtTemperatureMinActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int temperature = Integer.parseInt(txtTemperatureMin.getText());
            VirtualHardwareManager.getInstance().setTemperatureMin(temperature);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid temperature value", "Error", JOptionPane.ERROR_MESSAGE);
            txtTemperatureMin.setText("20");
        }
    }

    private void txtTemperatureMaxActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int temperature = Integer.parseInt(txtTemperatureMax.getText());
            VirtualHardwareManager.getInstance().setTemperatureMax(temperature);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid temperature value", "Error", JOptionPane.ERROR_MESSAGE);
            txtTemperatureMax.setText("50");
        }
    }

    private void txtHumidityMinActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int humidity = Integer.parseInt(txtHumidityMin.getText());
            VirtualHardwareManager.getInstance().setHumidityMin(humidity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid humidity value", "Error", JOptionPane.ERROR_MESSAGE);
            txtHumidityMin.setText("20");
        }
    }

    private void txtHumidityMaxActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int humidity = Integer.parseInt(txtHumidityMax.getText());
            VirtualHardwareManager.getInstance().setHumidityMax(humidity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid humidity value", "Error", JOptionPane.ERROR_MESSAGE);
            txtHumidityMax.setText("50");
        }
    }

    private void spinnerIntervalStateChanged(javax.swing.event.ChangeEvent evt) {
        try {
            int interval = Integer.parseInt(spinnerInterval.getValue().toString());
            AgentManager.getInstance().setPushInterval(interval);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid time interval value", "Error", JOptionPane.ERROR_MESSAGE);
            spinnerInterval.setValue(5);
        }
    }

    private void cmbInterfaceActionPerformed(java.awt.event.ActionEvent evt) {
        AgentManager.getInstance().setInterface(cmbInterface.getSelectedIndex());
    }

    private void cmbProtocolActionPerformed(java.awt.event.ActionEvent evt) {
        if (cmbProtocol.getSelectedIndex() != -1 && cmbProtocol.getItemAt(
                cmbProtocol.getSelectedIndex()).equals(AgentConstants.HTTP_PROTOCOL)) {
            cmbInterface.setEnabled(true);
        } else {
            cmbInterface.setEnabled(false);
        }

        AgentManager.getInstance().setProtocol(cmbProtocol.getSelectedIndex());

    }

    private void txtTemperatureSVFActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int temperatureSVF = Integer.parseInt(txtTemperatureSVF.getText());
            VirtualHardwareManager.getInstance().setTemperatureSVF(temperatureSVF);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid value", "Error", JOptionPane.ERROR_MESSAGE);
            txtTemperatureSVF.setText("50");
        }
    }

    private void txtHumiditySVFActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int humiditySVF = Integer.parseInt(txtHumiditySVF.getText());
            VirtualHardwareManager.getInstance().setHumiditySVF(humiditySVF);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid value", "Error", JOptionPane.ERROR_MESSAGE);
            txtHumiditySVF.setText("50");
        }
    }

    private void chkbxTemperatureSmoothActionPerformed(java.awt.event.ActionEvent evt) {
        isTemperatureSmoothed = chkbxTemperatureSmooth.isSelected();
        txtTemperatureSVF.setEnabled(isTemperatureSmoothed);
        VirtualHardwareManager.getInstance().setIsTemperatureSmoothed(isTemperatureSmoothed);
    }

    private void chkbxHumiditySmoothActionPerformed(java.awt.event.ActionEvent evt) {
        isHumiditySmoothed = chkbxHumiditySmooth.isSelected();
        txtHumiditySVF.setEnabled(isHumiditySmoothed);
        VirtualHardwareManager.getInstance().setIsHumiditySmoothed(isHumiditySmoothed);
    }

    private void cmbPeriodActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void chkbxEmulateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void setAlarmStatus(boolean isAlarmOn) {
        this.isAlarmOn = isAlarmOn;
    }

    public void updateTemperature(int temperature) {
        spinnerTemperature.setValue(temperature);
        spinnerTemperature.updateUI();
    }

    public void updateHumidity(int humidity) {
        spinnerHumidity.setValue(humidity);
        spinnerHumidity.updateUI();
    }

    public void addToPolicyLog(String policy) {
        synchronized (this._lock) {
            policyLogs.add(policy);
        }
    }

    private String getPolicyLog() {
        synchronized (this._lock) {
            if (policyLogs.size() > 0) {
                String policy = policyLogs.get(0);
                policyLogs.remove(0);
                return policy;
            } else {
                return null;
            }
        }
    }

}
