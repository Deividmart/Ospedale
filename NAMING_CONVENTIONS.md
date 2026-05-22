# Convenciones de Nombres — Componentes Gráficos

Referencia para el Día 7: renombrar todos los componentes de las vistas.
Prefijos usados: `txt` (JTextField), `btn` (JButton), `lbl` (JLabel),
`cmb` (JComboBox), `tbl` (JTable), `txa` (JTextArea), `rdb` (JRadioButton),
`pnl` (JPanel), `tab` (JTabbedPane), `scr` (JScrollPane).

---

## LoginView (NewJFrame) — Tab: Login

| Nombre actual | Nombre nuevo       | Tipo        | Descripción                        |
|---------------|--------------------|-------------|------------------------------------|
| jLabel1       | lblTitle           | JLabel      | Título "LOGIN"                     |
| jLabel2       | lblUsername        | JLabel      | Etiqueta Username                  |
| jTextField1   | txtUsername        | JTextField  | Campo de usuario                   |
| jLabel3       | lblPassword        | JLabel      | Etiqueta Password                  |
| jTextField2   | txtPassword        | JTextField  | Campo de contraseña                |
| jButton2      | btnEnter           | JButton     | Botón ENTER (iniciar sesión)       |
| jButton1      | btnClose           | JButton     | Botón X (cerrar aplicación)        |
| panelRound1   | pnlMain            | PanelRound  | Panel principal                    |
| panelRound2   | pnlHeader          | PanelRound  | Panel de cabecera / drag           |

## LoginView (NewJFrame) — Tab: Patient Register

| Nombre actual | Nombre nuevo         | Tipo        | Descripción                      |
|---------------|----------------------|-------------|----------------------------------|
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
| jPanel3       | pnlPatientRegister   | JPanel      | Panel de registro de paciente    |
| jTabbedPane1  | tabLogin             | JTabbedPane | Pestañas Login / Patient Register|

---

## PatientView (NewJFrame1)

### Tab: Appointment history
| Nombre actual | Nombre nuevo       | Tipo        | Descripción                          |
|---------------|--------------------|-------------|--------------------------------------|
| jLabel1       | lblViewTitle       | JLabel      | Título "PATIENT VIEW"                |
| jButton1      | btnClose           | JButton     | Botón X (cerrar)                     |
| jButton7      | btnBack            | JButton     | Botón Back (solo visible para admin) |
| jTable1       | tblAppointments    | JTable      | Tabla historial de citas             |
| jScrollPane3  | scrAppointments    | JScrollPane | Scroll de la tabla de citas          |
| jButton6      | btnRefresh         | JButton     | Botón Refresh (recargar tabla)       |
| jButton8      | btnLogout          | JButton     | Botón Logout                         |
| jPanel3       | pnlAppointmentHistory | JPanel   | Panel historial de citas             |

### Tab: Modify info
| Nombre actual | Nombre nuevo         | Tipo        | Descripción                        |
|---------------|----------------------|-------------|------------------------------------|
| jLabel2       | lblFirstname         | JLabel      | Etiqueta Firstname                 |
| jTextField1   | txtFirstname         | JTextField  | Campo Firstname                    |
| jLabel3       | lblLastname          | JLabel      | Etiqueta Lastname                  |
| jTextField2   | txtLastname          | JTextField  | Campo Lastname                     |
| jLabel5       | lblBirthdate         | JLabel      | Etiqueta Birthdate                 |
| jTextField4   | txtBirthdate         | JTextField  | Campo Birthdate (YYYY-MM-DD)       |
| jLabel6       | lblGender            | JLabel      | Etiqueta Gender                    |
| jComboBox6    | cmbGender            | JComboBox   | Combo Female/Male                  |
| jLabel7       | lblEmail             | JLabel      | Etiqueta Email                     |
| jTextField6   | txtEmail             | JTextField  | Campo Email                        |
| jLabel8       | lblPhone             | JLabel      | Etiqueta Phone                     |
| jTextField7   | txtPhone             | JTextField  | Campo Phone                        |
| jLabel9       | lblAddress           | JLabel      | Etiqueta Address                   |
| jTextField8   | txtAddress           | JTextField  | Campo Address                      |
| jLabel12      | lblUsername          | JLabel      | Etiqueta User                      |
| jTextField11  | txtUsername          | JTextField  | Campo Username                     |
| jLabel10      | lblPassword          | JLabel      | Etiqueta Password                  |
| jTextField9   | txtPassword          | JTextField  | Campo Password                     |
| jLabel11      | lblConfirmPwd        | JLabel      | Etiqueta Password confirmation     |
| jTextField10  | txtConfirmPwd        | JTextField  | Campo confirmación contraseña      |
| jButton9      | btnSaveInfo          | JButton     | Botón Save (actualizar info)       |
| jPanel1       | pnlModifyInfo        | JPanel      | Panel modificar información        |

### Tab: Request/Cancel
| Nombre actual | Nombre nuevo          | Tipo          | Descripción                               |
|---------------|-----------------------|---------------|-------------------------------------------|
| jLabel13      | lblRequestAppointment | JLabel        | Título "Request medical appointment"      |
| jRadioButton3 | rdbBySpecialty        | JRadioButton  | Radio "Specialty"                         |
| jRadioButton4 | rdbByDoctor           | JRadioButton  | Radio "Doctor"                            |
| jComboBox5    | cmbSpecialtyOrDoctor  | JComboBox     | Combo especialidad o doctor               |
| jLabel14      | lblAppointmentDate    | JLabel        | Etiqueta Appointment date                 |
| jTextField12  | txtAppointmentDate    | JTextField    | Campo fecha cita (YYYY-MM-DD)             |
| jLabel15      | lblAppointmentTime    | JLabel        | Etiqueta Appointment time                 |
| jTextField13  | txtAppointmentTime    | JTextField    | Campo hora cita (hh:mm)                   |
| jLabel16      | lblAppointmentType    | JLabel        | Etiqueta Appointment type                 |
| jComboBox1    | cmbAppointmentType    | JComboBox     | Combo Remote/In-person                    |
| jLabel17      | lblAppointmentReason  | JLabel        | Etiqueta Appointment reason               |
| jTextArea4    | txaAppointmentReason  | JTextArea     | Área razón de la cita                     |
| jScrollPane5  | scrAppointmentReason  | JScrollPane   | Scroll del área razón                     |
| jButton3      | btnCreateAppointment  | JButton       | Botón Create (solicitar cita)             |
| jLabel18      | lblRequestHosp        | JLabel        | Título "Request hospitalization"          |
| jLabel19      | lblHospReason         | JLabel        | Etiqueta Hospitalization reason           |
| jTextArea3    | txaHospReason         | JTextArea     | Área razón hospitalización                |
| jScrollPane4  | scrHospReason         | JScrollPane   | Scroll razón hospitalización              |
| jLabel20      | lblAttendingDoctor    | JLabel        | Etiqueta Attending doctor                 |
| jComboBox2    | cmbAttendingDoctor    | JComboBox     | Combo doctores disponibles                |
| jLabel21      | lblHospDate           | JLabel        | Etiqueta Estimated date of admission      |
| jTextField16  | txtHospDate           | JTextField    | Campo fecha hospitalización (YYYY-MM-DD)  |
| jLabel22      | lblRoomType           | JLabel        | Etiqueta Desired room type                |
| jComboBox3    | cmbRoomType           | JComboBox     | Combo tipo de habitación                  |
| jLabel23      | lblHospObservations   | JLabel        | Etiqueta Observations                     |
| jTextArea1    | txaHospObservations   | JTextArea     | Área observaciones hospitalización        |
| jScrollPane1  | scrHospObservations   | JScrollPane   | Scroll observaciones                      |
| jButton4      | btnCreateHosp         | JButton       | Botón Create (solicitar hospitalización)  |
| jLabel24      | lblCancelAppointment  | JLabel        | Título "Cancel appointment"               |
| jLabel25      | lblCancelId           | JLabel        | Etiqueta ID appointment                   |
| jComboBox4    | cmbCancelAppointmentId| JComboBox     | Combo IDs de citas del paciente           |
| jLabel26      | lblCancelObservations | JLabel        | Etiqueta Observations                     |
| jTextArea2    | txaCancelObservations | JTextArea     | Área observaciones cancelación            |
| jScrollPane2  | scrCancelObservations | JScrollPane   | Scroll observaciones cancelación          |
| jButton5      | btnCancelAppointment  | JButton       | Botón Cancel (cancelar cita)              |
| jPanel2       | pnlRequestCancel      | JPanel        | Panel solicitar/cancelar                  |
| jTabbedPane1  | tabPatient            | JTabbedPane   | Pestañas de la vista paciente             |

---

## AdminView (NewJFrame11)

| Nombre actual | Nombre nuevo        | Tipo        | Descripción                              |
|---------------|---------------------|-------------|------------------------------------------|
| jButton1      | btnClose            | JButton     | Botón X (cerrar)                         |
| jLabel1       | lblViewTitle        | JLabel      | Título "ADMIN VIEW"                      |
| jButton2      | btnGoToPatient      | JButton     | Ir a vista de paciente                   |
| jButton3      | btnGoToDoctor       | JButton     | Ir a vista de doctor                     |
| jButton10     | btnLogout           | JButton     | Botón Logout                             |
| jButton9      | btnSaveDoctor       | JButton     | Botón guardar doctor                     |
| jLabel4       | lblDocFirstname     | JLabel      | Etiqueta Firstname                       |
| jTextField3   | txtDocFirstname     | JTextField  | Campo Firstname del doctor               |
| jLabel5       | lblDocLastname      | JLabel      | Etiqueta Lastname                        |
| jTextField4   | txtDocLastname      | JTextField  | Campo Lastname del doctor                |
| jLabel6       | lblDocId            | JLabel      | Etiqueta ID                              |
| jTextField5   | txtDocId            | JTextField  | Campo ID doctor (12 dígitos)             |
| jLabel7       | lblDocSpecialty     | JLabel      | Etiqueta Specialty                       |
| jComboBox1    | cmbDocSpecialty     | JComboBox   | Combo especialidades                     |
| jLabel8       | lblDocLicence       | JLabel      | Etiqueta Licence number                  |
| jTextField6   | txtDocLicence       | JTextField  | Campo licencia (L-XXXXXXXXXX MTL)        |
| jLabel9       | lblDocOffice        | JLabel      | Etiqueta Assigned office                 |
| jTextField7   | txtDocOffice        | JTextField  | Campo oficina (O-XXX)                    |
| jLabel10      | lblDocUsername      | JLabel      | Etiqueta Username                        |
| jTextField8   | txtDocUsername      | JTextField  | Campo username del doctor                |
| jLabel11      | lblDocPassword      | JLabel      | Etiqueta Password                        |
| jTextField9   | txtDocPassword      | JTextField  | Campo password del doctor                |
| jLabel12      | lblDocConfirmPwd    | JLabel      | Etiqueta Password confirmation           |
| jTextField10  | txtDocConfirmPwd    | JTextField  | Campo confirmación contraseña            |
| jComboBox2    | cmbSelectPatient    | JComboBox   | Combo seleccionar paciente               |
| jLabel13      | lblSelectPatient    | JLabel      | Etiqueta seleccionar paciente            |
| jLabel14      | lblSelectDoctor     | JLabel      | Etiqueta seleccionar doctor              |
| jComboBox3    | cmbSelectDoctor     | JComboBox   | Combo seleccionar doctor                 |
| panelRound3   | pnlRegisterDoctor   | PanelRound  | Panel registro de doctor                 |

---

## DoctorView (NewJFrame111)

| Nombre actual | Nombre nuevo           | Tipo        | Descripción                               |
|---------------|------------------------|-------------|-------------------------------------------|
| jButton1      | btnClose               | JButton     | Botón X (cerrar)                          |
| jLabel1       | lblViewTitle           | JLabel      | Título "DOCTOR VIEW"                      |
| jButton11     | btnBack                | JButton     | Botón Back (solo visible para admin)      |
| jButton8      | btnLogout              | JButton     | Botón Logout                              |
| jTabbedPane1  | tabDoctor              | JTabbedPane | Pestañas de la vista doctor               |
| jRadioButton3 | rdbAllAppointments     | JRadioButton| Radio "All appointments"                  |
| jRadioButton4 | rdbPendingAppointments | JRadioButton| Radio "Pending appointments"              |
| jTable2       | tblAppointments        | JTable      | Tabla de citas del doctor                 |
| jScrollPane3  | scrAppointments        | JScrollPane | Scroll tabla citas                        |
| jButton12     | btnRefreshAppointments | JButton     | Botón Refresh tabla citas                 |
| jTable3       | tblHospitalizations    | JTable      | Tabla hospitalizaciones                   |
| jScrollPane4  | scrHospitalizations    | JScrollPane | Scroll tabla hospitalizaciones            |
| jComboBox5    | cmbAppointmentId       | JComboBox   | Combo ID cita para acciones               |
| jLabel38      | lblSelectAppointment   | JLabel      | Etiqueta seleccionar cita                 |
| jButton3      | btnAcceptAppointment   | JButton     | Botón aceptar cita (REQUESTED→PENDING)    |
| jButton4      | btnCompleteAppointment | JButton     | Botón completar cita (PENDING→COMPLETED)  |
| jComboBox2    | cmbHospitalizationId   | JComboBox   | Combo ID hospitalización para acciones    |
| jLabel13      | lblAcceptHosp          | JLabel      | Etiqueta aceptar hospitalización          |
| jButton9      | btnSaveDoctorInfo      | JButton     | Botón guardar info del doctor             |
| jTextField1   | txtDocFirstname        | JTextField  | Campo Firstname                           |
| jTextField2   | txtDocLastname         | JTextField  | Campo Lastname                            |
| jComboBox1    | cmbDocSpecialty        | JComboBox   | Combo especialidad                        |
| jTextField6   | txtDocLicence          | JTextField  | Campo licencia                            |
| jTextField7   | txtDocOffice           | JTextField  | Campo oficina                             |
| jTextField8   | txtDocUsername         | JTextField  | Campo username                            |
| jTextField9   | txtDocPassword         | JTextField  | Campo password                            |
| jTextField10  | txtDocConfirmPwd       | JTextField  | Campo confirmación contraseña             |
| jTextField13  | txtRescheduleTime      | JTextField  | Campo nueva hora reagendamiento (hh:mm)   |
| jTextField14  | txtRescheduleReason    | JTextField  | Campo razón del reagendamiento            |
| jComboBox3    | cmbPrescribeAppointId  | JComboBox   | Combo ID cita para prescribir             |
| jLabel15      | lblMedicationName      | JLabel      | Etiqueta medication name                  |
| jLabel16      | lblDose                | JLabel      | Etiqueta dose                             |
| jLabel17      | lblAdminRoute          | JLabel      | Etiqueta administration route             |
| jLabel18      | lblTreatmentDuration   | JLabel      | Etiqueta treatment duration               |
