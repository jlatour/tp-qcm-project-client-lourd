package vues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import vues.composants.boutonsCRUD;
import vues.composants.tableauReponses;
import vues.composants.boutonsCRUD.CRUD_ACTION;
import vues.composants.boutonsCRUD.CRUD_CONTEXT;
import vues.evenements.BtnAddThemeEventHandler;
import vues.evenements.BtnCrudEventHandler;
import vues.evenements.ListQuestionsEvent;
import controleurs.CtrlQuestion;

public class PanelQuestion extends JPanel {

	private static final long serialVersionUID = -4942247434619055619L;
	private CtrlQuestion _ctrl;
	private static PanelQuestion _instance;
	
	private BorderLayout panelQuestionLayout;
	private GridBagLayout centerLayout;;
	
	private JPanel centerPanel;
	private Box leftPanel;
	
	private JList listeQuestions;
	private JTextArea enonce;
	private JComboBox cbxTypeDeQuestion;
	private JComboBox cbxTheme;
	private tableauReponses listeReponses;
	private boutonsCRUD boutonsCRUD_WEST;
	private JButton btnNewButton;
	private boutonsCRUD boutonsCRUD_;

	@SuppressWarnings("static-access")
	private PanelQuestion() {

		panelQuestionLayout = new BorderLayout();
		panelQuestionLayout.setHgap(10);
		this.setLayout(panelQuestionLayout);
		add(new JPanel(), panelQuestionLayout.NORTH);
		add(new JPanel(), panelQuestionLayout.EAST);
		add(getLeftPanel(), panelQuestionLayout.WEST);
		add(new JPanel(), panelQuestionLayout.SOUTH);
		
		try {
			add(getCenterPanel(), panelQuestionLayout.CENTER);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}

		try {
			getListeQuestions().setListData(getCtrl().chargerQuestions());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		getListeQuestions().addListSelectionListener(new ListQuestionsEvent());
		if(getListeQuestions().getModel().getSize() > 0){
			getListeQuestions().setSelectedIndex(0);
			boutonsCRUD_WEST.setActionSUPPR();
		}
		else{
			boutonsCRUD_WEST.setActionNULL();
		}
	}

	public static PanelQuestion getInstance() {
		if (_instance == null) {
			_instance = new PanelQuestion();
		}
		return _instance;
	}

	public CtrlQuestion getCtrl() {
		if (_ctrl == null) {
			_ctrl = CtrlQuestion.getInstance();
		}
		return _ctrl;
	}

	public JList getListeQuestions(){
		if (listeQuestions == null) {
			listeQuestions = new JList();
			listeQuestions.setPreferredSize(new Dimension(100, 200));
			listeQuestions.setMinimumSize(new Dimension(200, 300));
			listeQuestions.setBorder(new TitledBorder(null, "Questions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			listeQuestions.setSize(250, HEIGHT);
			listeQuestions.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return listeQuestions;
	}
	
	public JTextArea getEnonce(){
		if(enonce == null){
			enonce = new JTextArea();
			enonce.setBorder(new TitledBorder(null, "Enonc\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			enonce.setColumns(35);
			enonce.setRows(5);
		}
		return enonce;
	}
	
	public JPanel getCenterPanel() throws Exception{
		if(centerPanel == null){
			centerPanel = new JPanel();
			GridBagLayout gbl = new GridBagLayout();
			gbl.columnWidths = new int[]{0, 0, 100, 2};
			gbl.rowHeights = new int[]{0, 0, 97, 0, 0, 0, 0, 0, 0, 5};
			gbl.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			centerPanel.setLayout(gbl);
			
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.gridwidth = 3;
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.insets = new Insets(0, 0, 5, 0);
			gbc_textArea.gridx = 0;
			gbc_textArea.gridy = 2;
			centerPanel.add(getEnonce(), gbc_textArea);
			
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 0;
			gbc_comboBox.gridy = 3;
			centerPanel.add(getCbxTypeDeQuestion(), gbc_comboBox);
			
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.insets = new Insets(0, 0, 5, 0);
			gbc_table.gridwidth = 3;
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.gridx = 0;
			gbc_table.gridy = 4;
			centerPanel.add(getReponses(), gbc_table);
			
			GridBagConstraints gbc_boutonsCRUD_ = new GridBagConstraints();
			gbc_boutonsCRUD_.fill = GridBagConstraints.VERTICAL;
			gbc_boutonsCRUD_.anchor = GridBagConstraints.EAST;
			gbc_boutonsCRUD_.insets = new Insets(0, 0, 5, 0);
			gbc_boutonsCRUD_.gridx = 2;
			gbc_boutonsCRUD_.gridy = 5;
			centerPanel.add(getBoutonsCRUD_(), gbc_boutonsCRUD_);
			
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_1.anchor = GridBagConstraints.NORTH;
			gbc_comboBox_1.gridwidth = 2;
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.gridx = 0;
			gbc_comboBox_1.gridy = 7;
			centerPanel.add(getCbxTheme(), gbc_comboBox_1);
			
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 7;
			centerPanel.add(getBtnNewButton(), gbc_btnNewButton);

		}
		return centerPanel;
	}

	public GridBagLayout getCenterLayout() {
		if(centerLayout == null){
			centerLayout = new GridBagLayout();
		}
		return centerLayout;
	}
	
	public JComboBox getCbxTypeDeQuestion() throws Exception{
		if(cbxTypeDeQuestion == null){
			cbxTypeDeQuestion = new JComboBox(getCtrl().chargerTypesDeQuestion());
			cbxTypeDeQuestion.setBorder(new TitledBorder(null, "Type de question", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return cbxTypeDeQuestion;
	}

	public JComboBox getCbxTheme() throws Exception{
		if(cbxTheme == null){
			cbxTheme = new JComboBox(getCtrl().chargerThemes());
			cbxTheme.setBorder(new TitledBorder(null, "Th\u00E8me", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return cbxTheme;
	}
	
	public tableauReponses getReponses(){
		if(listeReponses == null){
			listeReponses = new tableauReponses();
			listeReponses.getTableauReponse().setPreferredScrollableViewportSize(new Dimension(0, 0));
		}
		return listeReponses;
	}

	public Box getLeftPanel() {
		if(leftPanel == null){
			leftPanel = new Box(BoxLayout.Y_AXIS);
			leftPanel.add(getListeQuestions());
			leftPanel.add(Box.createVerticalGlue());
			leftPanel.add(getBoutonsCRUD_WEST());
		}
		return leftPanel;
	}
	
	public boutonsCRUD getBoutonsCRUD_WEST() {
		if (boutonsCRUD_WEST == null) {
			boutonsCRUD_WEST = new boutonsCRUD();
			boutonsCRUD_WEST.setPreferredSize(new Dimension(128, 32));
			boutonsCRUD_WEST.getBtnADD().addActionListener(new BtnCrudEventHandler(CRUD_CONTEXT.QUESTION, CRUD_ACTION.ADD));
			boutonsCRUD_WEST.getBtnSUPPR().addActionListener(new BtnCrudEventHandler(CRUD_CONTEXT.QUESTION, CRUD_ACTION.REMOVE));
			boutonsCRUD_WEST.getBtnOK().addActionListener(new BtnCrudEventHandler(CRUD_CONTEXT.QUESTION, CRUD_ACTION.CONFIRM));
			boutonsCRUD_WEST.getBtnOK().addActionListener(new BtnCrudEventHandler(CRUD_CONTEXT.QUESTION, CRUD_ACTION.REMOVE));
		}
		return boutonsCRUD_WEST;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new BtnAddThemeEventHandler());
			btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNewButton.setMinimumSize(new Dimension(32, 32));
			btnNewButton.setMaximumSize(new Dimension(32, 32));
			btnNewButton.setIcon(new ImageIcon(PanelQuestion.class.getResource("/vues/composants/btnImages/add.png")));
		}
		return btnNewButton;
	}
	private boutonsCRUD getBoutonsCRUD_() {
		if (boutonsCRUD_ == null) {
			boutonsCRUD_ = new boutonsCRUD();
			boutonsCRUD_.setSize(new Dimension(128, 32));
			boutonsCRUD_.setPreferredSize(new Dimension(128, 32));
			boutonsCRUD_.setMinimumSize(new Dimension(128, 32));
			
		}
		return boutonsCRUD_;
	}
}
