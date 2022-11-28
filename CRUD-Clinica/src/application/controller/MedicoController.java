package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Medico;
import application.persistence.MedicoDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicoController implements IMedicoController{
	
	private TextField tfCrm;
    private TextField tfNomeMedico;
    private TextField tfLogradouroMedico;
    private TextField tfNumMedico;
    private TextField tfCepMedico;
	private TextField tfComplMedico;
    private TextField tfTelMedico;
    private TextField tfEmailMedico;
    private TextArea taListarMedicos;
    
    public MedicoController(TextField tfCrm, TextField tfNomeMedico, TextField tfLogradouroMedico,
			TextField tfNumMedico, TextField tfCepMedico, TextField tfComplMedico, TextField tfTelMedico,
			TextField tfEmailMedico, TextArea taListarMedicos) {
		this.tfCrm = tfCrm;
		this.tfNomeMedico = tfNomeMedico;
		this.tfLogradouroMedico = tfLogradouroMedico;
		this.tfNumMedico = tfNumMedico;
		this.tfCepMedico = tfCepMedico;
		this.tfComplMedico = tfComplMedico;
		this.tfTelMedico = tfTelMedico;
		this.tfEmailMedico = tfEmailMedico;
		this.taListarMedicos = taListarMedicos;
	}

	@Override
	public void inserirMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.insereMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void atualizarMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.atualizaMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void excluirMedico(Medico m) throws ClassNotFoundException, SQLException {
		MedicoDAO mDao = new MedicoDAO();
        mDao.excluiMedico(m);
        limpaCampoMedico();
        buscarMedicos();
	}

	@Override
	public void buscarMedico(Medico m) throws ClassNotFoundException, SQLException {
		limpaCampoMedico();
        
		MedicoDAO mDao = new MedicoDAO();
        mDao.consultaMedico(m);

        tfCrm.setText(m.getCrm());
        tfNomeMedico.setText(m.getNome());
        tfLogradouroMedico.setText(m.getLogradouro());
        tfNumMedico.setText(String.valueOf(m.getNumEnd()));
        tfCepMedico.setText(m.getCep());
        tfComplMedico.setText(m.getComplemento());
        tfTelMedico.setText(m.getTelefone());
        tfEmailMedico.setText(m.getEmail());
	}

	@Override
	public void buscarMedicos() throws ClassNotFoundException, SQLException {
		limpaCampoMedico();
		taListarMedicos.setText("");
		
		MedicoDAO mDao = new MedicoDAO();
				List<Medico> listaMedicos = mDao.listaMedico();

        StringBuffer buffer = new StringBuffer("\t CPF\tNome\tLogradouro\tnumero\tCEP\tComplemento\ttipo Sanguineo\temail");

        for(Medico m : listaMedicos){
            buffer.append(m.getCrm()+"\t"+m.getNome()+"\t"+m.getLogradouro()+"\t"+m.getNumEnd()+"\t"+m.getCep()+"\t"+m.getComplemento()+"\t"+m.getEmail());
        }
        taListarMedicos.setText(buffer.toString());
	}
	
    private void limpaCampoMedico(){
        tfCrm.setText("");
        tfNomeMedico.setText("");
        tfLogradouroMedico.setText("");
        tfNumMedico.setText("");
        tfCepMedico.setText("");
    	tfComplMedico.setText("");
        tfTelMedico.setText("");
        tfEmailMedico.setText("");
    }
	
	
	
}