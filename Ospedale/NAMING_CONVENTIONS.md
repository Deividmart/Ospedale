# Convenciones de Nombres — Componentes Gráficos

Referencia para renombrar todos los componentes de las vistas.
Prefijos usados: `txt` (JTextField), `btn` (JButton), `lbl` (JLabel),
`cmb` (JComboBox), `tbl` (JTable), `txa` (JTextArea), `rdb` (JRadioButton),
`pnl` (JPanel), `tab` (JTabbedPane), `scr` (JScrollPane).

---

## LoginView (NewJFrame)

### Componentes generales
| Nombre actual | Nombre nuevo  | Tipo        | Descripción                          |
|---------------|---------------|-------------|--------------------------------------|
| jTabbedPane1  | tabLogin      | JTabbedPane | Pestañas Login / Patient Register    |
| panelRound1   | pnlMain       | PanelRound  | Panel principal                      |
| panelRound2   | pnlHeader     | PanelRound  | Panel de cabecera / drag             |
| jButton1      | btnClose      | JButton     | Botón X (cerrar aplicación)          |

### Tab: Login
| Nombre actual | Nombre nuevo  | Tipo       | Descripción              |
|---------------|---------------|------------|--------------------------|
| jLabel1       | lblLogin      | JLabel     | Título "LOGIN"           |
| jLabel2       | lblUsername   | JLabel     | Etiqueta Username        |
| jTextField1   | txtUsername   | JTextField | Campo de usuario         |
| jLabel3       | lblPassword   | JLabel     | Etiqueta Password        |
| jTextField2   | txtPassword   | JTextField | Campo de contraseña      |
| jButton2      | btnEnter      | JButton    | Botón ENTER (iniciar sesión) |

### Tab: Patient Register
| Nombre actual | Nombre nuevo         | Tipo        | Descripción                      |
|---------------|----------------------|-------------|----------------------------------|
| jPanel3       | pnlPatientRegister   | JPanel      | Panel de registro de paciente    |
| jLabel4       | lblRegFirstname      | JLabel      | Etiqueta Firstname               |
| jTextField3   | txtRegFirstname      | JTextField  | Campo Firstname                  |
| jLabel5       | lblRegLastname       | JLabel      | Etiqueta Lastname                |
| jTextField4   | txtRegLastname       | JTextField  | Campo Lastname                   |
| jLabel6       | lblRegId             | JLabel      | Etiqueta ID                      |
| jTextField5   | txtRegId             | JTextField  | Campo ID (12 dígitos)            |
| jLabel7       | lblRegGender         | JLabel      | Etiqueta Gender                  |
| jComboBox1    | cmbRegGender         | JComboBox   | Combo Female/Male                |
| jLabel8       | lblRegPhone          | JLabel      | Etiqueta Phone                   |
| jTextField6   | txtRegPhone          | JTextField  | Campo Phone (10 dígitos)         |
| jLabel9       | lblRegEmail          | JLabel      | Etiqueta Email                   |
| jTextField7   | txtRegEmail          | JTextField  | Campo Email                      |
| jLabel10      | lblRegUsername       | JLabel      | Etiqueta User                    |
| jTextField8   | txtRegUsername       | JTextField  | Campo Username                   |
| jLabel11      | lblRegPassword       | JLabel      | Etiqueta Password                |
| jTextField9   | txtRegPassword       | JTextField  | Campo Password                   |
| jLabel12      | lblRegConfirmPwd     | JLabel      | Etiqueta Password confirmation   |
| jTextField10  | txtRegConfirmPwd     | JTextField  | Campo confirmación contraseña    |
| jLabel13      | lblRegAddress        | JLabel      | Etiqueta Address                 |
| jTextField11  | txtRegAddress        | JTextField  | Campo Address                    |
| jLabel14      | lblRegBirthdate      | JLabel      | Etiqueta Birthdate               |
| jTextField12  | txtRegBirthdate      | JTextField  | Campo Birthdate (YYYY-MM-DD)     |
| jButton9      | btnRegSave           | JButton     | Botón Save (registrar paciente)  |

---

## PatientView (NewJFrame1)

### Componentes generales
| Nombre actual | Nombre nuevo  | Tipo        | Descripción                          |
|---------------|---------------|-------------|--------------------------------------|
| jTabbedPane1  | tabPatient    | JTabbedPane | Pestañas de la vista paciente        |
| jLabel1       | lblPatientView | JLabel      | Título "PATIENT VIEW"                |
| jButton1      | btnClose       | JButton     | Botón X (cerrar)                     |
| jButton7      | btnBack        | JButton     | Botón Back (solo visible para admin) |
| jButton8      | btnLogout      | JButton     | Botón Logout                         |

### Tab: Appointment history
| Nombre actual | Nombre nuevo          | Tipo        | Descripción                  |
|---------------|-----------------------|-------------|------------------------------|
| jPanel3       | pnlAppointmentHistory | JPanel      | Panel historial de citas     |
| jTable1       | tblAppointments       | JTable      | Tabla historial de citas     |
| jScrollPane3  | scrAppointments       | JScrollPane | Scroll de la tabla de citas  |
| jButton6      | btnRefresh            | JButton     | Botón Refresh (recargar tabla) |

### Tab: Modify info
| Nombre actual | Nombre nuevo     | Tipo        | Descripción                        |
|---------------|------------------|-------------|------------------------------------|
| jPanel1       | pnlModifyInfo    | JPanel      | Panel modificar información        |
| jLabel2       | lblFirstname     | JLabel      | Etiqueta Firstname                 |
| jTextField1   | txtFirstname     | JTextField  | Campo Firstname                    |
| jLabel3       | lblLastname      | JLabel      | Etiqueta Lastname                  |
| jTextField2   | txtLastname      | JTextField  | Campo Lastname                     |
| jLabel5       | lblBirthdate     | JLabel      | Etiqueta Birthdate                 |
| jTextField4   | txtBirthdate     | JTextField  | Campo Birthdate (YYYY-MM-DD)       |
| jLabel6       | lblGender        | JLabel      | Etiqueta Gender                    |
| jComboBox6    | cmbGender        | JComboBox   | Combo Female/Male                  |
| jLabel7       | lblEmail         | JLabel      | Etiqueta Email                     |
| jTextField6   | txtEmail         | JTextField  | Campo Email                        |
| jLabel8       | lblPhone         | JLabel      | Etiqueta Phone                     |
| jTextField7   | txtPhone         | JTextField  | Campo Phone                        |
| jLabel9       | lblAddress       | JLabel      | Etiqueta Address                   |
| jTextField8   | txtAddress       | JTextField  | Campo Address                      |
| jLabel12      | lblUsername      | JLabel      | Etiqueta User                      |
| jTextField11  | txtUsername      | JTextField  | Campo Username                     |
| jLabel10      | lblPassword      | JLabel      | Etiqueta Password                  |
| jTextField9   | txtPassword      | JTextField  | Campo Password                     |
| jLabel11      | lblConfirmPwd    | JLabel      | Etiqueta Password confirmation     |
| jTextField10  | txtConfirmPwd    | JTextField  | Campo confirmación contraseña      |
| jButton9      | btnSave          | JButton     | Botón Save (actualizar info paciente)|

### Tab: Request/Cancel
| Nombre actual | Nombre nuevo           | Tipo          | Descripción                               |
|---------------|------------------------|---------------|-------------------------------------------|
| jPanel2       | pnlRequestCancel       | JPanel        | Panel solicitar/cancelar                  |
| jLabel13      | lblRequestAppointment  | JLabel        | Título "Request medical appointment"      |
| jRadioButton3 | rdbBySpecialty         | JRadioButton  | Radio "Specialty"                         |
| jRadioButton4 | rdbByDoctor            | JRadioButton  | Radio "Doctor"                            |
| jComboBox5    | cmbSpecialtyOrDoctor   | JComboBox     | Combo especialidad o doctor               |
| jLabel14      | lblAppointmentDate     | JLabel        | Etiqueta Appointment date                 |
| jTextField12  | txtAppointmentDate     | JTextField    | Campo fecha cita (YYYY-MM-DD)             |
| jLabel15      | lblAppointmentTime     | JLabel        | Etiqueta Appointment time                 |
| jTextField13  | txtAppointmentTime     | JTextField    | Campo hora cita (hh:mm)                   |
| jLabel16      | lblAppointmentType     | JLabel        | Etiqueta Appointment type                 |
| jComboBox1    | cmbAppointmentType     | JComboBox     | Combo Remote/In-person                    |
| jLabel17      | lblAppointmentReason   | JLabel        | Etiqueta Appointment reason               |
| jTextArea4    | txaAppointmentReason   | JTextArea     | Área razón de la cita                     |
| jScrollPane5  | scrAppointmentReason   | JScrollPane   | Scroll del área razón                     |
| jButton3      | btnCreateAppointment   | JButton       | Botón Create (solicitar cita)             |
| jLabel18      | lblRequestHosp         | JLabel        | Título "Request hospitalization"          |
| jLabel19      | lblHospReason          | JLabel        | Etiqueta Hospitalization reason           |
| jTextArea3    | txaHospReason          | JTextArea     | Área razón hospitalización                |
| jScrollPane4  | scrHospReason          | JScrollPane   | Scroll razón hospitalización              |
| jLabel20      | lblAttendingDoctor     | JLabel        | Etiqueta Attending doctor                 |
| jComboBox2    | cmbAttendingDoctor     | JComboBox     | Combo doctores disponibles                |
| jLabel21      | lblHospDate            | JLabel        | Etiqueta Estimated date of admission      |
| jTextField16  | txtHospDate            | JTextField    | Campo fecha hospitalización (YYYY-MM-DD)  |
| jLabel22      | lblRoomType            | JLabel        | Etiqueta Desired room type                |
| jComboBox3    | cmbRoomType            | JComboBox     | Combo tipo de habitación                  |
| jLabel23      | lblHospObservations    | JLabel        | Etiqueta Observations                     |
| jTextArea1    | txaHospObservations    | JTextArea     | Área observaciones hospitalización        |
| jScrollPane1  | scrHospObservations    | JScrollPane   | Scroll observaciones                      |
| jButton4      | btnCreateHosp          | JButton       | Botón Create (solicitar hospitalización)  |
| jLabel24      | lblCancelAppointment   | JLabel        | Título "Cancel appointment"               |
| jLabel25      | lblCancelId            | JLabel        | Etiqueta ID appointment                   |
| jComboBox4    | cmbCancelAppointmentId | JComboBox     | Combo IDs de citas del paciente           |
| jLabel26      | lblCancelObservations  | JLabel        | Etiqueta Observations                     |
| jTextArea2    | txaCancelObservations  | JTextArea     | Área observaciones cancelación            |
| jScrollPane2  | scrCancelObservations  | JScrollPane   | Scroll observaciones cancelación          |
| jButton5      | btnCancelAppointment   | JButton       | Botón Cancel (cancelar cita)              |

---

## AdminView (NewJFrame11)

| Nombre actual | Nombre nuevo      | Tipo        | Descripción                              |
|---------------|-------------------|-------------|------------------------------------------|
| jButton1      | btnClose          | JButton     | Botón X (cerrar)                         |
| jLabel1       | lblAdminView      | JLabel      | Título "ADMIN VIEW"                      |
| jButton10     | btnLogout         | JButton     | Botón Logout                             |
| jButton9      | btnSaveDoctor     | JButton     | Botón guardar doctor                     |
| jLabel4       | lblDocFirstname   | JLabel      | Etiqueta Firstname                       |
| jTextField3   | txtDocFirstname   | JTextField  | Campo Firstname del doctor               |
| jLabel5       | lblDocLastname    | JLabel      | Etiqueta Lastname                        |
| jTextField4   | txtDocLastname    | JTextField  | Campo Lastname del doctor                |
| jLabel6       | lblDocId          | JLabel      | Etiqueta ID                              |
| jTextField5   | txtDocId          | JTextField  | Campo ID doctor (12 dígitos)             |
| jLabel7       | lblDocSpecialty   | JLabel      | Etiqueta Specialty                       |
| jComboBox1    | cmbDocSpecialty   | JComboBox   | Combo especialidades                     |
| jLabel8       | lblDocLicence     | JLabel      | Etiqueta Licence number                  |
| jTextField6   | txtDocLicence     | JTextField  | Campo licencia (L-XXXXXXXXXX MTL)        |
| jLabel9       | lblDocOffice      | JLabel      | Etiqueta Assigned office                 |
| jTextField7   | txtDocOffice      | JTextField  | Campo oficina (O-XXX)                    |
| jLabel10      | lblDocUsername    | JLabel      | Etiqueta Username                        |
| jTextField8   | txtDocUsername    | JTextField  | Campo username del doctor                |
| jLabel11      | lblDocPassword    | JLabel      | Etiqueta Password                        |
| jTextField9   | txtDocPassword    | JTextField  | Campo password del doctor                |
| jLabel12      | lblDocConfirmPwd  | JLabel      | Etiqueta Password confirmation           |
| jTextField10  | txtDocConfirmPwd  | JTextField  | Campo confirmación contraseña            |
| jLabel13      | lblSelectPatient  | JLabel      | Etiqueta seleccionar paciente            |
| jComboBox2    | cmbSelectDoctor   | JComboBox   | Combo seleccionar doctor                 |
| jButton2      | btnGoToDoctor     | JButton     | Ir a vista de doctor                     |
| jLabel14      | lblSelectDoctor   | JLabel      | Etiqueta seleccionar doctor              |
| jComboBox3    | cmbSelectPatient  | JComboBox   | Combo seleccionar paciente               |
| jButton3      | btnGoToPatient    | JButton     | Ir a vista de paciente                   |
| panelRound3   | pnlRegisterDoctor | PanelRound  | Panel registro de doctor                 |

---

## DoctorView (NewJFrame111)

### Componentes generales
| Nombre actual | Nombre nuevo  | Tipo        | Descripción                               |
|---------------|---------------|-------------|-------------------------------------------|
| jTabbedPane1  | tabDoctor     | JTabbedPane | Pestañas de la vista doctor               |
| jButton1      | btnClose      | JButton     | Botón X (cerrar)                          |
| jLabel1       | lblDoctorView | JLabel      | Título "DOCTOR VIEW"                      |
| jButton11     | btnBack       | JButton     | Botón Back (solo visible para admin)      |
| jButton12     | btnLogout     | JButton     | Botón Logout                              |

### Tab: Appointments visualization
| Nombre actual | Nombre nuevo           | Tipo         | Descripción                           |
|---------------|------------------------|--------------|---------------------------------------|
| jPanel4       | pnlAppointmentViz      | JPanel       | Panel visualización de citas          |
| jRadioButton3 | rdbTotalAppointments   | JRadioButton | Radio "Total appointments"            |
| jRadioButton4 | rdbPendingAppointments | JRadioButton | Radio "Pending appointments"          |
| jTable2       | tblAppointments        | JTable       | Tabla de citas del doctor             |
| jScrollPane3  | scrAppointments        | JScrollPane  | Scroll tabla citas                    |

### Tab: History appointments of a patient
| Nombre actual | Nombre nuevo        | Tipo        | Descripción                              |
|---------------|---------------------|-------------|------------------------------------------|
| jPanel5       | pnlPatientHistory   | JPanel      | Panel historial de citas de un paciente  |
| jLabel38      | lblSelectPatient    | JLabel      | Etiqueta seleccionar paciente            |
| jComboBox5    | cmbSelectPatient    | JComboBox   | Combo IDs de pacientes                   |
| jButton8      | btnSearchPatient    | JButton     | Botón Search (buscar historial)          |
| jTable3       | tblPatientHistory   | JTable      | Tabla historial del paciente             |
| jScrollPane4  | scrPatientHistory   | JScrollPane | Scroll tabla historial paciente          |

### Tab: Modify info
| Nombre actual | Nombre nuevo      | Tipo        | Descripción                        |
|---------------|-------------------|-------------|------------------------------------|
| jPanel3       | pnlModifyInfo     | JPanel      | Panel modificar info del doctor    |
| jLabel2       | lblFirstname      | JLabel      | Etiqueta Firstname                 |
| jTextField1   | txtFirstname      | JTextField  | Campo Firstname                    |
| jLabel3       | lblLastname       | JLabel      | Etiqueta Lastname                  |
| jTextField2   | txtLastname       | JTextField  | Campo Lastname                     |
| jLabel5       | lblSpecialty      | JLabel      | Etiqueta Specialty                 |
| jComboBox1    | cmbSpecialty      | JComboBox   | Combo especialidades               |
| jLabel7       | lblLicence        | JLabel      | Etiqueta Licence number            |
| jTextField6   | txtLicence        | JTextField  | Campo licencia                     |
| jLabel8       | lblOffice         | JLabel      | Etiqueta Assigned office           |
| jTextField7   | txtOffice         | JTextField  | Campo oficina                      |
| jLabel9       | lblUsername       | JLabel      | Etiqueta Username                  |
| jTextField8   | txtUsername       | JTextField  | Campo username                     |
| jLabel10      | lblPassword       | JLabel      | Etiqueta Password                  |
| jTextField9   | txtPassword       | JTextField  | Campo password                     |
| jLabel11      | lblConfirmPwd     | JLabel      | Etiqueta Password confirmation     |
| jTextField10  | txtConfirmPwd     | JTextField  | Campo confirmación contraseña      |
| jButton9      | btnSave           | JButton     | Botón Save (guardar info doctor)   |

### Tab: Request/Appointments
| Nombre actual | Nombre nuevo            | Tipo         | Descripción                                    |
|---------------|-------------------------|--------------|------------------------------------------------|
| jPanel1       | pnlRequestAppointments  | JPanel       | Panel gestión de citas y hospitalizaciones     |
| jLabel13      | lblAcceptAppt           | JLabel       | Título "Accept appointment"                    |
| jLabel14      | lblApptId               | JLabel       | Etiqueta Appointment (para aceptar)            |
| jComboBox2    | cmbApptId               | JComboBox    | Combo ID cita para aceptar                     |
| jButton3      | btnAcceptAppointment    | JButton      | Botón Accept (REQUESTED→PENDING)               |
| jLabel15      | lblRescheduleAppt       | JLabel       | Título "Reschedule appointment"                |
| jLabel16      | lblRescheduleApptId     | JLabel       | Etiqueta Appointment (para reprogramar)        |
| jComboBox3    | cmbRescheduleApptId     | JComboBox    | Combo ID cita para reprogramar                 |
| jLabel17      | lblNewTime              | JLabel       | Etiqueta New time appointment                  |
| jTextField13  | txtNewTime              | JTextField   | Campo nueva hora (hh:mm)                       |
| jLabel18      | lblRescheduleReason     | JLabel       | Etiqueta Reason for rescheduling               |
| jTextField14  | txtRescheduleReason     | JTextField   | Campo razón del reagendamiento                 |
| jButton4      | btnRescheduleAppointment| JButton      | Botón Reschedule (reagendar cita)              |
| jLabel19      | lblCompleteAppt         | JLabel       | Título "Complete appointment"                  |
| jLabel20      | lblCompleteApptId       | JLabel       | Etiqueta Appointment (para completar)          |
| jComboBox4    | cmbCompleteApptId       | JComboBox    | Combo ID cita para completar                   |
| jLabel21      | lblDiagnosis            | JLabel       | Etiqueta Diagnosis                             |
| jTextArea5    | txaDiagnosis            | JTextArea    | Área diagnóstico                               |
| jScrollPane6  | scrDiagnosis            | JScrollPane  | Scroll diagnóstico                             |
| jLabel22      | lblCompleteObservations | JLabel       | Etiqueta Observations                          |
| jTextArea6    | txaCompleteObservations | JTextArea    | Área observaciones de la cita                  |
| jScrollPane7  | scrCompleteObservations | JScrollPane  | Scroll observaciones                           |
| jLabel23      | lblRecommendedTreatment | JLabel       | Etiqueta Recommended treatment                 |
| jTextArea7    | txaRecommendedTreatment | JTextArea    | Área tratamiento recomendado                   |
| jScrollPane8  | scrRecommendedTreatment | JScrollPane  | Scroll tratamiento                             |
| jLabel24      | lblFollowUp             | JLabel       | Etiqueta Follow-up indication                  |
| jTextArea8    | txaFollowUp             | JTextArea    | Área indicación de seguimiento                 |
| jScrollPane9  | scrFollowUp             | JScrollPane  | Scroll seguimiento                             |
| jButton5      | btnCompleteAppointment  | JButton      | Botón Complete (PENDING→COMPLETED)             |
| jLabel25      | lblHospitalization      | JLabel       | Título "Hospitalization"                       |
| jRadioButton5 | rdbHospRequests         | JRadioButton | Radio "Requests" (ver solicitudes hosp.)       |
| jRadioButton6 | rdbPatientId            | JRadioButton | Radio "From Appointment" (hosp. desde cita)    |
| jComboBox6    | cmbHospOrApptId         | JComboBox    | Combo hosp. IDs (Requests) / appt IDs (FromAppt)|
| jComboBox8    | cmbRoomType             | JComboBox    | Combo tipo de habitación (para hosp.)          |
| jLabel27      | lblHospReason           | JLabel       | Etiqueta Reason for hospitalization            |
| jTextArea9    | txaHospReason           | JTextArea    | Área razón hospitalización desde cita          |
| jScrollPane10 | scrHospReason           | JScrollPane  | Scroll razón hospitalización                   |
| jLabel28      | lblHospDate             | JLabel       | Etiqueta Date of entry                         |
| jTextField21  | txtHospDate             | JTextField   | Campo fecha hospitalización (YYYY-MM-DD)       |
| jLabel29      | lblHospDuration         | JLabel       | Etiqueta Estimated duration                    |
| jTextField22  | txtHospDuration         | JTextField   | Campo duración estimada                        |
| jLabel30      | lblHospObservations     | JLabel       | Etiqueta Observations                          |
| jTextArea1    | txaHospObservations     | JTextArea    | Área observaciones hospitalización             |
| jScrollPane1  | scrHospObservations     | JScrollPane  | Scroll observaciones hospitalización           |
| jButton6      | btnGenerateHosp         | JButton      | Botón Generate (aceptar hosp. / hosp. desde cita)|
| jButton13     | btnCancelHosp           | JButton      | Botón Cancel (denegar hospitalización)         |

### Tab: Prescribe medications
| Nombre actual | Nombre nuevo         | Tipo        | Descripción                              |
|---------------|----------------------|-------------|------------------------------------------|
| jPanel2       | pnlPrescribe         | JPanel      | Panel prescribir medicamentos            |
| jLabel31      | lblPrescribeApptId   | JLabel      | Etiqueta Appointment ID                  |
| jComboBox7    | cmbPrescribeApptId   | JComboBox   | Combo ID cita para prescribir            |
| jLabel32      | lblMedicationName    | JLabel      | Etiqueta Medication name                 |
| jTextField24  | txtMedicationName    | JTextField  | Campo nombre del medicamento             |
| jLabel33      | lblDose              | JLabel      | Etiqueta Dose                            |
| jTextField25  | txtDose              | JTextField  | Campo dosis                              |
| jLabel34      | lblAdminRoute        | JLabel      | Etiqueta Administration route            |
| jTextField26  | txtAdminRoute        | JTextField  | Campo vía de administración              |
| jLabel35      | lblFrequency         | JLabel      | Etiqueta Frequency                       |
| jTextField27  | txtFrequency         | JTextField  | Campo frecuencia                         |
| jLabel36      | lblTreatmentDuration | JLabel      | Etiqueta Treatment duration              |
| jTextField28  | txtTreatmentDuration | JTextField  | Campo duración del tratamiento           |
| jLabel37      | lblInstructions      | JLabel      | Etiqueta Additional instructions         |
| jTextField29  | txtInstructions      | JTextField  | Campo instrucciones adicionales          |
| jButton7      | btnAddMedication     | JButton     | Botón Add (añadir medicamento a tabla)   |
| jTable1       | tblPrescriptions     | JTable      | Tabla de medicamentos a prescribir       |
| jScrollPane2  | scrPrescriptions     | JScrollPane | Scroll tabla medicamentos                |
| jButton10     | btnPrescribe         | JButton     | Botón Prescribe (enviar prescripción)    |
