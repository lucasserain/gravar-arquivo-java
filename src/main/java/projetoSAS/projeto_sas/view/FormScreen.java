package projetoSAS.projeto_sas.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import projetoSAS.projeto_sas.controller.GravarArquivo;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FormScreen {

	private JFrame frame;
	private JTextField txtNomeBase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormScreen window = new FormScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNomeDaBase = new JLabel("Nome da Base:");
		
		txtNomeBase = new JTextField();
		txtNomeBase.setColumns(10);
		
		JLabel lblCorDoTexto = new JLabel("Cor do texto: ");
		
		final JComboBox comboCorTexto = new JComboBox();
		comboCorTexto.setModel(new DefaultComboBoxModel(new String[] {"Verde", "Vermelho", "Azul"}));
		
		final JXDatePicker datePicker = new JXDatePicker();
		
		JLabel lblData = new JLabel("Data: ");
		//------------------Logica de gravaacao aqui------------------------------------------
		JButton btnGerarArquivo = new JButton("Gerar Arquivo");
		btnGerarArquivo.addActionListener(new ActionListener() {
			//Ao clica no botao, instancia a classe GravarArquivo, passando as string pro Array e gravando-as.
			public void actionPerformed(ActionEvent arg0) {
				Date localDate = datePicker.getDate();
				GravarArquivo gravarArquivo = new GravarArquivo();
				gravarArquivo.gravarArrayList(txtNomeBase.getText());
				gravarArquivo.gravarArrayList(comboCorTexto.getSelectedItem().toString());
				gravarArquivo.gravarArrayList(localDate.toString());
				gravarArquivo.writeInFile();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNomeDaBase)
					.addGap(6)
					.addComponent(txtNomeBase, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCorDoTexto)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGerarArquivo)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboCorTexto, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(135))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNomeDaBase))
						.addComponent(txtNomeBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCorDoTexto))
						.addComponent(comboCorTexto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblData))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnGerarArquivo)
					.addGap(59))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
