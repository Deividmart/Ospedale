/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.AdminView;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controller.AcceptAppointmentController;
import controller.AcceptHospitalizationController;
import controller.CancelHospitalizationController;
import controller.CompleteAppointmentController;
import controller.GetDataController;
import controller.HospitalizeFromAppointmentController;
import controller.interfaces.IAcceptAppointmentController;
import controller.interfaces.IAcceptHospitalizationController;
import controller.interfaces.ICancelHospitalizationController;
import controller.interfaces.ICompleteAppointmentController;
import controller.interfaces.IGetDataController;
import controller.interfaces.IHospitalizeFromAppointmentController;
import controller.interfaces.IPrescribeMedicationController;
import controller.interfaces.IRescheduleAppointmentController;
import controller.interfaces.IUpdateDoctorController;
import controller.PrescribeMedicationController;
import controller.RescheduleAppointmentController;
import controller.Response;
import controller.UpdateDoctorController;

/**
 *
 * @author jjlora
 * @author edangulo
 */
public class DoctorView extends javax.swing.JFrame implements model.interfaces.ModelObserver {

    private int x, y;
    private model.User user;
    private model.Doctor doctor;
    private final model.DataStore store = model.DataStore.getInstance();

    public DoctorView(model.User loggedUser, model.Doctor viewedDoctor) {
        initComponents();
        this.user = loggedUser;
        this.doctor = viewedDoctor;
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        btnBack.setVisible(loggedUser instanceof model.Administrator);
        loadAppointmentCombos();
        loadHospitalizationComboBox();
        loadPatientComboBox();
        loadRoomTypeComboBox();
        prefillDoctorData();
        setupHospitalizationRadioListeners();
        store.addObserver(this);
    }

    @Override
    public void onModelChanged() {
        if (rdbPendingAppointments.isSelected()) {
            rdbPendingAppointmentsActionPerformed(null);
        } else {
            rdbTotalAppointmentsActionPerformed(null);
        }
        loadHospitalizationComboBox();
    }

    private void loadRoomTypeComboBox() {
        cmbRoomType.removeAllItems();
        for (model.RoomType rt : model.RoomType.values()) {
            cmbRoomType.addItem(rt.name());
        }
    }

    private void prefillDoctorData() {
        txtFirstname.setText(doctor.getFirstname());
        txtLastname.setText(doctor.getLastname());
        txtLicence.setText(doctor.getLicenceNumber());
        txtUsername.setText(doctor.getUsername());
        txtOffice.setText(doctor.getAssignedOffice());
        cmbSpecialty.setSelectedItem(doctor.getSpecialty().name());
    }

    private void setupHospitalizationRadioListeners() {
        rdbHospRequests.addActionListener(e -> {
            cmbHospOrApptId.removeAllItems();
            cmbHospOrApptId.addItem("Select one");
            for (model.Hospitalization h : doctor.getHospitalizations()) {
                cmbHospOrApptId.addItem(h.getId());
            }
        });
        rdbPatientId.addActionListener(e -> {
            cmbHospOrApptId.removeAllItems();
            cmbHospOrApptId.addItem("Select one");
            for (model.Appointment a : doctor.getAppointments()) {
                cmbHospOrApptId.addItem(a.getId());
            }
        });
    }

    private void loadAppointmentCombos() {
        cmbApptId.removeAllItems(); cmbApptId.addItem("Select one");
        cmbRescheduleApptId.removeAllItems(); cmbRescheduleApptId.addItem("Select one");
        cmbCompleteApptId.removeAllItems(); cmbCompleteApptId.addItem("Select one");
        cmbPrescribeApptId.removeAllItems(); cmbPrescribeApptId.addItem("Select one");
        for (model.Appointment a : doctor.getAppointments()) {
            cmbApptId.addItem(a.getId());
            cmbRescheduleApptId.addItem(a.getId());
            cmbCompleteApptId.addItem(a.getId());
            cmbPrescribeApptId.addItem(a.getId());
        }
    }

    private void loadHospitalizationComboBox() {
        cmbHospOrApptId.removeAllItems();
        cmbHospOrApptId.addItem("Select one");
        for (model.Hospitalization h : doctor.getHospitalizations()) {
            cmbHospOrApptId.addItem(h.getId());
        }
    }

    private void loadPatientComboBox() {
        cmbSelectPatient.removeAllItems();
        cmbSelectPatient.addItem("Select one");
        for (model.Patient p : store.getPatients()) {
            cmbSelectPatient.addItem(String.valueOf(p.getId()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new packagee.PanelRound();
        panelRound2 = new packagee.PanelRound();
        btnClose = new javax.swing.JButton();
        lblDoctorView = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        tabDoctor = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        rdbTotalAppointments = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        rdbPendingAppointments = new javax.swing.JRadioButton();
        btnLogout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cmbSelectPatient = new javax.swing.JComboBox<>();
        lblSelectPatient = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPatientHistory = new javax.swing.JTable();
        btnSearchPatient = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblFirstname = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        lblSpecialty = new javax.swing.JLabel();
        lblLicence = new javax.swing.JLabel();
        txtLicence = new javax.swing.JTextField();
        lblOffice = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtOffice = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPwd = new javax.swing.JLabel();
        txtConfirmPwd = new javax.swing.JTextField();
        cmbSpecialty = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblApptId = new javax.swing.JLabel();
        lblAcceptAppt = new javax.swing.JLabel();
        cmbApptId = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnAcceptAppointment = new javax.swing.JButton();
        lblRescheduleAppt = new javax.swing.JLabel();
        lblRescheduleApptId = new javax.swing.JLabel();
        cmbRescheduleApptId = new javax.swing.JComboBox<>();
        btnRescheduleAppointment = new javax.swing.JButton();
        lblNewTime = new javax.swing.JLabel();
        txtNewTime = new javax.swing.JTextField();
        lblRescheduleReason = new javax.swing.JLabel();
        txtRescheduleReason = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblCompleteAppt = new javax.swing.JLabel();
        lblCompleteApptId = new javax.swing.JLabel();
        cmbCompleteApptId = new javax.swing.JComboBox<>();
        lblDiagnosis = new javax.swing.JLabel();
        lblCompleteObservations = new javax.swing.JLabel();
        lblRecommendedTreatment = new javax.swing.JLabel();
        lblFollowUp = new javax.swing.JLabel();
        btnCompleteAppointment = new javax.swing.JButton();
        lblHospitalization = new javax.swing.JLabel();
        lblHospReason = new javax.swing.JLabel();
        lblHospDate = new javax.swing.JLabel();
        txtHospDate = new javax.swing.JTextField();
        lblHospDuration = new javax.swing.JLabel();
        txtHospDuration = new javax.swing.JTextField();
        lblHospObservations = new javax.swing.JLabel();
        scrHospObservations = new javax.swing.JScrollPane();
        txaHospObservations = new javax.swing.JTextArea();
        btnGenerateHosp = new javax.swing.JButton();
        cmbHospOrApptId = new javax.swing.JComboBox<>();
        rdbHospRequests = new javax.swing.JRadioButton();
        rdbPatientId = new javax.swing.JRadioButton();
        scrDiagnosis = new javax.swing.JScrollPane();
        txaDiagnosis = new javax.swing.JTextArea();
        scrCompleteObservations = new javax.swing.JScrollPane();
        txaCompleteObservations = new javax.swing.JTextArea();
        scrRecommendedTreatment = new javax.swing.JScrollPane();
        txaRecommendedTreatment = new javax.swing.JTextArea();
        scrFollowUp = new javax.swing.JScrollPane();
        txaFollowUp = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        btnCancelHosp = new javax.swing.JButton();
        cmbRoomType = new javax.swing.JComboBox<>();
        scrHospReason = new javax.swing.JScrollPane();
        txaHospReason = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblPrescribeApptId = new javax.swing.JLabel();
        lblMedicationName = new javax.swing.JLabel();
        txtMedicationName = new javax.swing.JTextField();
        lblDose = new javax.swing.JLabel();
        txtDose = new javax.swing.JTextField();
        lblAdminRoute = new javax.swing.JLabel();
        txtAdminRoute = new javax.swing.JTextField();
        lblFrequency = new javax.swing.JLabel();
        txtFrequency = new javax.swing.JTextField();
        lblTreatmentDuration = new javax.swing.JLabel();
        txtTreatmentDuration = new javax.swing.JTextField();
        lblInstructions = new javax.swing.JLabel();
        txtInstructions = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrescriptions = new javax.swing.JTable();
        btnAddMedication = new javax.swing.JButton();
        btnPrescribe = new javax.swing.JButton();
        cmbPrescribeApptId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setRadius(50);

        panelRound2.setRadius(50);
        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRound2MouseDragged(evt);
            }
        });
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound2MousePressed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnClose.setText("X");
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClose.setFocusable(false);
        btnClose.setRequestFocusEnabled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblDoctorView.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblDoctorView.setText("DOCTOR VIEW");

        btnBack.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoctorView)
                .addGap(32, 32, 32)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(19, 19, 19))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDoctorView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBack))
        );

        rdbTotalAppointments.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rdbTotalAppointments.setText("Total appointments");
        rdbTotalAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTotalAppointmentsActionPerformed(evt);
            }
        });

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Patient", "Specialty", "Type", "Status"
            }
        ));
        jScrollPane3.setViewportView(tblAppointments);

        rdbPendingAppointments.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rdbPendingAppointments.setText("Pending appointments");
        rdbPendingAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPendingAppointmentsActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(rdbTotalAppointments)
                            .addGap(18, 18, 18)
                            .addComponent(rdbPendingAppointments))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTotalAppointments)
                    .addComponent(rdbPendingAppointments))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(23, 23, 23))
        );

        tabDoctor.addTab("Appointments visualization", jPanel4);

        cmbSelectPatient.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbSelectPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        lblSelectPatient.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblSelectPatient.setText("Patient");

        tblPatientHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Doctor", "Specialty", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPatientHistory);

        btnSearchPatient.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSearchPatient.setText("Search");
        btnSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblSelectPatient)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSearchPatient)
                .addGap(601, 601, 601))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectPatient)
                    .addComponent(cmbSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSearchPatient)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tabDoctor.addTab("History Appointments of a patient", jPanel5);

        lblFirstname.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFirstname.setText("Firstname");

        txtFirstname.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblLastname.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblLastname.setText("Lastname");

        txtLastname.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblSpecialty.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblSpecialty.setText("Specialty");

        lblLicence.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblLicence.setText("License Number");

        txtLicence.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblOffice.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblOffice.setText("Assigned office");

        txtUsername.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("User");

        txtOffice.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password");

        lblConfirmPwd.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblConfirmPwd.setText("Password confirmation");

        txtConfirmPwd.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        cmbSpecialty.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbSpecialty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "General Medicine", "Cardiology", "Pediatrics", "Neurology", "Traumatology & Orthopedics", "Gynecology & Obstetrics", "Dermatology", "Psychiatry", "Oncology", "Ophthalmology", "Internal Medicine" }));

        btnSave.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lblFirstname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLastname)
                        .addGap(18, 18, 18)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSpecialty)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(lblLicence)
                        .addGap(18, 18, 18)
                        .addComponent(txtLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblOffice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(558, 558, 558)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(lblConfirmPwd))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addComponent(btnSave))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(561, 561, 561)
                        .addComponent(txtConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastname)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpecialty)
                    .addComponent(cmbSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLicence)
                    .addComponent(txtLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOffice))
                .addGap(30, 30, 30)
                .addComponent(lblUsername)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addGap(27, 27, 27)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblConfirmPwd)
                .addGap(18, 18, 18)
                .addComponent(txtConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSave)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        tabDoctor.addTab("Modify info", jPanel3);

        lblApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblApptId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApptId.setText("Appointment ID");

        lblAcceptAppt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblAcceptAppt.setText("Accept medical appointment");

        cmbApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbApptId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnAcceptAppointment.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAcceptAppointment.setText("Accept");
        btnAcceptAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptAppointmentActionPerformed(evt);
            }
        });

        lblRescheduleAppt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRescheduleAppt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRescheduleAppt.setText("Reschedule medical appointment");

        lblRescheduleApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRescheduleApptId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRescheduleApptId.setText("Appointment");

        cmbRescheduleApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbRescheduleApptId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        btnRescheduleAppointment.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRescheduleAppointment.setText("Accept");
        btnRescheduleAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRescheduleAppointmentActionPerformed(evt);
            }
        });

        lblNewTime.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNewTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewTime.setText("New time appointment");

        txtNewTime.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblRescheduleReason.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRescheduleReason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRescheduleReason.setText("Reason for appointment");

        txtRescheduleReason.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblCompleteAppt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCompleteAppt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompleteAppt.setText("Complete medical appointment");

        lblCompleteApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCompleteApptId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompleteApptId.setText("Appointment");

        cmbCompleteApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbCompleteApptId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        lblDiagnosis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDiagnosis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDiagnosis.setText("Diagnosis");

        lblCompleteObservations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCompleteObservations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompleteObservations.setText("Observations");

        lblRecommendedTreatment.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRecommendedTreatment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecommendedTreatment.setText("Recommended treatment");

        lblFollowUp.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFollowUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFollowUp.setText("Follow-up indication");

        btnCompleteAppointment.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCompleteAppointment.setText("Complete");
        btnCompleteAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteAppointmentActionPerformed(evt);
            }
        });

        lblHospitalization.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHospitalization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHospitalization.setText("Hospitalization");

        lblHospReason.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHospReason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHospReason.setText("Reason for hospitalization");

        lblHospDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHospDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHospDate.setText("Date of entry");

        txtHospDate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblHospDuration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHospDuration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHospDuration.setText("Estimated duration");

        txtHospDuration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblHospObservations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHospObservations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHospObservations.setText("Observations");

        txaHospObservations.setColumns(20);
        txaHospObservations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaHospObservations.setRows(5);
        scrHospObservations.setViewportView(txaHospObservations);

        btnGenerateHosp.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnGenerateHosp.setText("Generate");
        btnGenerateHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateHospActionPerformed(evt);
            }
        });

        cmbHospOrApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbHospOrApptId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        rdbHospRequests.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rdbHospRequests.setText("Requests");

        rdbPatientId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rdbPatientId.setText("Patient ID");

        txaDiagnosis.setColumns(20);
        txaDiagnosis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaDiagnosis.setRows(5);
        scrDiagnosis.setViewportView(txaDiagnosis);

        txaCompleteObservations.setColumns(20);
        txaCompleteObservations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaCompleteObservations.setRows(5);
        scrCompleteObservations.setViewportView(txaCompleteObservations);

        txaRecommendedTreatment.setColumns(20);
        txaRecommendedTreatment.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaRecommendedTreatment.setRows(5);
        scrRecommendedTreatment.setViewportView(txaRecommendedTreatment);

        txaFollowUp.setColumns(20);
        txaFollowUp.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaFollowUp.setRows(5);
        scrFollowUp.setViewportView(txaFollowUp);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCancelHosp.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCancelHosp.setText("Cancel");
        btnCancelHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelHospActionPerformed(evt);
            }
        });

        cmbRoomType.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        txaHospReason.setColumns(20);
        txaHospReason.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaHospReason.setRows(5);
        scrHospReason.setViewportView(txaHospReason);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAcceptAppointment)
                                        .addGap(87, 87, 87))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67))))
                            .addComponent(lblApptId, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAcceptAppt)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRescheduleAppt, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRescheduleApptId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRescheduleReason, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(cmbRescheduleApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(txtNewTime, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(txtRescheduleReason, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addComponent(btnRescheduleAppointment)))
                            .addGap(91, 91, 91))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnCompleteAppointment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCompleteApptId, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCompleteAppt, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(cmbCompleteApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiagnosis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCompleteObservations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblFollowUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRecommendedTreatment, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(scrDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(scrCompleteObservations, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(scrRecommendedTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(scrFollowUp, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHospitalization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHospDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHospDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHospObservations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHospDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHospDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelHosp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGenerateHosp))
                            .addComponent(scrHospObservations, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbHospOrApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(rdbHospRequests)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHospReason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrHospReason, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCompleteAppt)
                        .addGap(10, 10, 10)
                        .addComponent(lblCompleteApptId)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCompleteApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDiagnosis)
                        .addGap(18, 18, 18)
                        .addComponent(scrDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCompleteObservations)
                        .addGap(18, 18, 18)
                        .addComponent(scrCompleteObservations, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRecommendedTreatment)
                        .addGap(18, 18, 18)
                        .addComponent(scrRecommendedTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFollowUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrFollowUp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCompleteAppointment)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblAcceptAppt)
                                .addGap(18, 18, 18)
                                .addComponent(lblApptId)
                                .addGap(18, 18, 18)
                                .addComponent(cmbApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnAcceptAppointment))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblRescheduleAppt)
                                .addGap(18, 18, 18)
                                .addComponent(lblRescheduleApptId)
                                .addGap(18, 18, 18)
                                .addComponent(cmbRescheduleApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNewTime)
                                .addGap(18, 18, 18)
                                .addComponent(txtNewTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblRescheduleReason)
                                .addGap(18, 18, 18)
                                .addComponent(txtRescheduleReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnRescheduleAppointment)))
                        .addGap(18, 18, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblHospitalization)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbHospRequests)
                    .addComponent(rdbPatientId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHospOrApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblHospReason)
                .addGap(16, 16, 16)
                .addComponent(scrHospReason, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHospDate)
                .addGap(18, 18, 18)
                .addComponent(txtHospDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHospDuration)
                .addGap(18, 18, 18)
                .addComponent(txtHospDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHospObservations)
                .addGap(18, 18, 18)
                .addComponent(scrHospObservations, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateHosp)
                    .addComponent(btnCancelHosp))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabDoctor.addTab("Request/Appointments", jPanel1);

        lblPrescribeApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblPrescribeApptId.setText("Appointment ID");

        lblMedicationName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblMedicationName.setText("Medication name");

        txtMedicationName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblDose.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDose.setText("Dose");

        txtDose.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblAdminRoute.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblAdminRoute.setText("Administration route");

        txtAdminRoute.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblFrequency.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFrequency.setText("Frecuency");

        txtFrequency.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblTreatmentDuration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTreatmentDuration.setText("Treatment duration");

        txtTreatmentDuration.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        lblInstructions.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblInstructions.setText("Additional instructions");

        txtInstructions.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        tblPrescriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Medication name", "Dose", "Administration route", "Treatment duration", "Additional instructions", "Frecuency"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPrescriptions);

        btnAddMedication.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAddMedication.setText("Add");
        btnAddMedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicationActionPerformed(evt);
            }
        });

        btnPrescribe.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnPrescribe.setText("Prescribe");
        btnPrescribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeActionPerformed(evt);
            }
        });

        cmbPrescribeApptId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbPrescribeApptId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblPrescribeApptId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPrescribeApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(lblMedicationName))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblTreatmentDuration)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTreatmentDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblInstructions)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFrequency)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtMedicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDose)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDose, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblAdminRoute)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAdminRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddMedication))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(btnPrescribe)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrescribeApptId)
                    .addComponent(lblMedicationName)
                    .addComponent(txtMedicationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDose)
                    .addComponent(txtDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdminRoute)
                    .addComponent(txtAdminRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMedication)
                    .addComponent(cmbPrescribeApptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTreatmentDuration)
                    .addComponent(txtTreatmentDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInstructions)
                    .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrequency)
                    .addComponent(txtFrequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnPrescribe)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tabDoctor.addTab("Prescribe medications", jPanel2);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabDoctor))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabDoctor))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRound2MousePressed

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRound2MouseDragged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void rdbPendingAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPendingAppointmentsActionPerformed
        rdbTotalAppointments.setSelected(false);
        IGetDataController ctrl = new GetDataController();
        Response response = ctrl.getDoctorAppointments(doctor, true);
        if (response.isSuccess()) {
            DefaultTableModel tableModel = (DefaultTableModel) tblAppointments.getModel();
            tableModel.setRowCount(0);
            ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) response.getData();
            for (Map<String, Object> row : data) {
                tableModel.addRow(new Object[]{
                    row.get("id"), row.get("datetime"), row.get("patient"),
                    row.get("specialty"), row.get("type"), row.get("status")
                });
            }
        }
    }//GEN-LAST:event_rdbPendingAppointmentsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        IUpdateDoctorController ctrl = new UpdateDoctorController();
        Response response = ctrl.update(
            doctor.getId(),
            txtUsername.getText(),
            txtFirstname.getText(),
            txtLastname.getText(),
            txtPassword.getText(),
            txtConfirmPwd.getText(),
            (String) cmbSpecialty.getSelectedItem(),
            txtLicence.getText(),
            txtOffice.getText()
        );
        if (response.isSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            txtFirstname.setText(""); txtLastname.setText(""); txtLicence.setText("");
            txtUsername.setText(""); txtOffice.setText(""); txtPassword.setText(""); txtConfirmPwd.setText("");
            cmbSpecialty.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.setVisible(false);
        new LoginRegisterView().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new AdminView(user).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelHospActionPerformed
        if (rdbHospRequests.isSelected()) {
            String selected = (String) cmbHospOrApptId.getSelectedItem();
            if (selected == null || selected.equals("Select one")) {
                JOptionPane.showMessageDialog(this, "Please select a hospitalization", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ICancelHospitalizationController ctrl = new CancelHospitalizationController();
            Response response = ctrl.cancel(doctor, selected);
            if (response.isSuccess()) {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
                loadHospitalizationComboBox();
            } else {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelHospActionPerformed

    private void btnGenerateHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateHospActionPerformed
        String selected = (String) cmbHospOrApptId.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select an item", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (rdbHospRequests.isSelected()) {
            IAcceptHospitalizationController ctrl = new AcceptHospitalizationController();
            Response response = ctrl.accept(doctor, selected);
            if (response.isSuccess()) {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
                loadHospitalizationComboBox();
            } else {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rdbPatientId.isSelected()) {
            String roomType = (String) cmbRoomType.getSelectedItem();
            IHospitalizeFromAppointmentController ctrl = new HospitalizeFromAppointmentController();
            Response response = ctrl.hospitalize(doctor, selected,
                txtHospDate.getText(), txaHospReason.getText(), roomType, txaHospObservations.getText());
            if (response.isSuccess()) {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
                loadAppointmentCombos();
                loadHospitalizationComboBox();
                txtHospDate.setText("");
                txaHospReason.setText("");
                txaHospObservations.setText("");
            } else {
                JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGenerateHospActionPerformed

    private void btnSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatientActionPerformed
        String selected = (String) cmbSelectPatient.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select a patient", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.Patient patient = (model.Patient) store.findUserById(Long.parseLong(selected));
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Patient not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        IGetDataController ctrl = new GetDataController();
        Response response = ctrl.getPatientAppointments(patient);
        if (response.isSuccess()) {
            DefaultTableModel tableModel = (DefaultTableModel) tblPatientHistory.getModel();
            tableModel.setRowCount(0);
            ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) response.getData();
            for (Map<String, Object> row : data) {
                tableModel.addRow(new Object[]{
                    row.get("id"), row.get("datetime"), row.get("doctor"),
                    row.get("specialty"), row.get("type"), row.get("status")
                });
            }
        }
    }//GEN-LAST:event_btnSearchPatientActionPerformed

    private void rdbTotalAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTotalAppointmentsActionPerformed
        rdbPendingAppointments.setSelected(false);
        IGetDataController ctrl = new GetDataController();
        Response response = ctrl.getDoctorAppointments(doctor, false);
        if (response.isSuccess()) {
            DefaultTableModel tableModel = (DefaultTableModel) tblAppointments.getModel();
            tableModel.setRowCount(0);
            ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) response.getData();
            for (Map<String, Object> row : data) {
                tableModel.addRow(new Object[]{
                    row.get("id"), row.get("datetime"), row.get("patient"),
                    row.get("specialty"), row.get("type"), row.get("status")
                });
            }
        }
    }//GEN-LAST:event_rdbTotalAppointmentsActionPerformed

    private void btnAcceptAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptAppointmentActionPerformed
        String selected = (String) cmbApptId.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select an appointment", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        IAcceptAppointmentController ctrl = new AcceptAppointmentController();
        Response response = ctrl.accept(doctor, selected);
        if (response.isSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            cmbApptId.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAcceptAppointmentActionPerformed

    private void btnCompleteAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteAppointmentActionPerformed
        String selected = (String) cmbCompleteApptId.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select an appointment", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ICompleteAppointmentController ctrl = new CompleteAppointmentController();
        Response response = ctrl.complete(doctor, selected);
        if (response.isSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            cmbCompleteApptId.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCompleteAppointmentActionPerformed

    private void btnPrescribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tblPrescriptions.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_btnPrescribeActionPerformed

    private void btnAddMedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicationActionPerformed
        String selected = (String) cmbPrescribeApptId.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select an appointment", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double dose;
        int treatmentDuration, frequency;
        try {
            dose = Double.parseDouble(txtDose.getText().trim());
            treatmentDuration = Integer.parseInt(txtTreatmentDuration.getText().trim());
            frequency = Integer.parseInt(txtFrequency.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dose, duration, and frequency must be numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        IPrescribeMedicationController ctrl = new PrescribeMedicationController();
        Response response = ctrl.prescribe(doctor, selected, txtMedicationName.getText(),
            dose, txtAdminRoute.getText(), treatmentDuration, txtInstructions.getText(), frequency);
        if (response.isSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel tableModel = (DefaultTableModel) tblPrescriptions.getModel();
            tableModel.addRow(new Object[]{
                selected,
                txtMedicationName.getText(),
                txtDose.getText(),
                txtAdminRoute.getText(),
                txtTreatmentDuration.getText(),
                txtInstructions.getText(),
                txtFrequency.getText()
            });
            cmbPrescribeApptId.setSelectedIndex(0);
            txtMedicationName.setText(""); txtDose.setText(""); txtAdminRoute.setText("");
            txtFrequency.setText(""); txtTreatmentDuration.setText(""); txtInstructions.setText("");
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddMedicationActionPerformed

    private void btnRescheduleAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRescheduleAppointmentActionPerformed
        String selected = (String) cmbRescheduleApptId.getSelectedItem();
        if (selected == null || selected.equals("Select one")) {
            JOptionPane.showMessageDialog(this, "Please select an appointment", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        IRescheduleAppointmentController ctrl = new RescheduleAppointmentController();
        Response response = ctrl.reschedule(doctor, selected, txtNewTime.getText(), txtRescheduleReason.getText());
        if (response.isSuccess()) {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            cmbRescheduleApptId.setSelectedIndex(0); txtNewTime.setText(""); txtRescheduleReason.setText("");
        } else {
            JOptionPane.showMessageDialog(this, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRescheduleAppointmentActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptAppointment;
    private javax.swing.JButton btnAddMedication;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelHosp;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCompleteAppointment;
    private javax.swing.JButton btnGenerateHosp;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPrescribe;
    private javax.swing.JButton btnRescheduleAppointment;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchPatient;
    private javax.swing.JComboBox<String> cmbApptId;
    private javax.swing.JComboBox<String> cmbCompleteApptId;
    private javax.swing.JComboBox<String> cmbHospOrApptId;
    private javax.swing.JComboBox<String> cmbPrescribeApptId;
    private javax.swing.JComboBox<String> cmbRescheduleApptId;
    private javax.swing.JComboBox<String> cmbRoomType;
    private javax.swing.JComboBox<String> cmbSelectPatient;
    private javax.swing.JComboBox<String> cmbSpecialty;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAcceptAppt;
    private javax.swing.JLabel lblAdminRoute;
    private javax.swing.JLabel lblApptId;
    private javax.swing.JLabel lblCompleteAppt;
    private javax.swing.JLabel lblCompleteApptId;
    private javax.swing.JLabel lblCompleteObservations;
    private javax.swing.JLabel lblConfirmPwd;
    private javax.swing.JLabel lblDiagnosis;
    private javax.swing.JLabel lblDoctorView;
    private javax.swing.JLabel lblDose;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblFollowUp;
    private javax.swing.JLabel lblFrequency;
    private javax.swing.JLabel lblHospDate;
    private javax.swing.JLabel lblHospDuration;
    private javax.swing.JLabel lblHospObservations;
    private javax.swing.JLabel lblHospReason;
    private javax.swing.JLabel lblHospitalization;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblLicence;
    private javax.swing.JLabel lblMedicationName;
    private javax.swing.JLabel lblNewTime;
    private javax.swing.JLabel lblOffice;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPrescribeApptId;
    private javax.swing.JLabel lblRecommendedTreatment;
    private javax.swing.JLabel lblRescheduleAppt;
    private javax.swing.JLabel lblRescheduleApptId;
    private javax.swing.JLabel lblRescheduleReason;
    private javax.swing.JLabel lblSelectPatient;
    private javax.swing.JLabel lblSpecialty;
    private javax.swing.JLabel lblTreatmentDuration;
    private javax.swing.JLabel lblUsername;
    private packagee.PanelRound panelRound1;
    private packagee.PanelRound panelRound2;
    private javax.swing.JRadioButton rdbHospRequests;
    private javax.swing.JRadioButton rdbPatientId;
    private javax.swing.JRadioButton rdbPendingAppointments;
    private javax.swing.JRadioButton rdbTotalAppointments;
    private javax.swing.JScrollPane scrCompleteObservations;
    private javax.swing.JScrollPane scrDiagnosis;
    private javax.swing.JScrollPane scrFollowUp;
    private javax.swing.JScrollPane scrHospObservations;
    private javax.swing.JScrollPane scrHospReason;
    private javax.swing.JScrollPane scrRecommendedTreatment;
    private javax.swing.JTabbedPane tabDoctor;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTable tblPatientHistory;
    private javax.swing.JTable tblPrescriptions;
    private javax.swing.JTextArea txaCompleteObservations;
    private javax.swing.JTextArea txaDiagnosis;
    private javax.swing.JTextArea txaFollowUp;
    private javax.swing.JTextArea txaHospObservations;
    private javax.swing.JTextArea txaHospReason;
    private javax.swing.JTextArea txaRecommendedTreatment;
    private javax.swing.JTextField txtAdminRoute;
    private javax.swing.JTextField txtConfirmPwd;
    private javax.swing.JTextField txtDose;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtFrequency;
    private javax.swing.JTextField txtHospDate;
    private javax.swing.JTextField txtHospDuration;
    private javax.swing.JTextField txtInstructions;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtLicence;
    private javax.swing.JTextField txtMedicationName;
    private javax.swing.JTextField txtNewTime;
    private javax.swing.JTextField txtOffice;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRescheduleReason;
    private javax.swing.JTextField txtTreatmentDuration;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
