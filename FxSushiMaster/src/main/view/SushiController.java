package main.view;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;
import main.vo.GuestVO;
import main.vo.JumunVO;
import main.vo.StoreVO;
import main.vo.SushiVO;

public class SushiController {
	@FXML
	private TableView<SushiVO> sushiTable;
	@FXML
	private TableColumn<SushiVO, String> sushiNoColumn;
	@FXML
	private TableColumn<SushiVO, String> sushiNameColumn;
	@FXML
	private TableView<GuestVO> guestTable;
	@FXML
	private TableColumn<GuestVO, String> guestNoColumn;
	@FXML
	private TableColumn<GuestVO, String> TableNoColumng;
	@FXML
	private TableView<JumunVO> jumunTable;
	@FXML
	private TableColumn<JumunVO, String> jumunNoColumn;
	@FXML
	private TableColumn<JumunVO, String> TableNoColumnj;
	@FXML
	TableView<StoreVO> storeTable;
	@FXML
	TableColumn<StoreVO, String> fishNoColums;
	@FXML
	TableColumn<StoreVO, String> fishAmount;
	///////////////////////////////////////////////////////
	@FXML
	private Label sushiNoLabel;
	@FXML
	private Label sushiNameLabel;
	@FXML
	private Label sushiPriceLabel;
	@FXML
	private Label fishNoLabel;
	@FXML
	private Label fishNameLabel;
	@FXML
	private Label fishInLabel;
	/////////////////////////////////////// ����â ��
	@FXML
	private Label guestNoLabelg;
	@FXML
	private Label tableNoLabelg;
	///////////////////////////// �մ����� ��
	@FXML
	private Label jumunNoLabel;
	@FXML
	private Label guestNoLabelj;
	@FXML
	private Label tableNoLabelj;
	@FXML
	private Label sushiNoLabelj;
	@FXML
	private Label sushiCountLabel;
	///////////////////////////// �ֹ����� ��
	@FXML
	private Label fishNoLabels;
	@FXML
	private Label fishAmountLabels;

	///////////////////////////// ���� ��
	///////////////////////////////////////
	@FXML
	private SplitPane sushi1;
	@FXML
	private SplitPane sushi2;
	@FXML
	private SplitPane sushi3;

	// ���� �� ����
	private Main main;

	//
	// ������
	public SushiController() {

	}

	// initialize() �޼���� fxml ������ �ε�ǰ� ���� �ڵ����� ȣ��. �׷��� ��� FXML �ʵ尡 �ʱ�ȭ.
	@FXML
	private void initialize() {
		// sushi�ʱ�ȭ
		sushiNoColumn.setCellValueFactory(cellData -> cellData.getValue().SushiNoProperty());
		sushiNameColumn.setCellValueFactory(cellData -> cellData.getValue().SushiNameProperty());
		// �մ� �ʱ�ȭ
		guestNoColumn.setCellValueFactory(cellData -> cellData.getValue().GuestNoProperty());
		TableNoColumng.setCellValueFactory(cellData -> cellData.getValue().TableNoProperty());
		// �ֹ� �ʱ�ȭ
		jumunNoColumn.setCellValueFactory(cellData -> cellData.getValue().JumunNoProperty());
		TableNoColumnj.setCellValueFactory(cellData -> cellData.getValue().TableNoProperty());
		// �󺧿� �󰪶���
		fishNoColums.setCellValueFactory(cellData -> cellData.getValue().FishNoProperty());
		fishAmount.setCellValueFactory(cellData -> cellData.getValue().FishAmountProperty());
		// ���Կ� �󰪶���
		showSushiDetails(null);
		showGuestDetails(null);
		showJumunDetails(null);
		showStoreDetails(null);
		// Listener�� ��ȭ ����,���̺��ð� �󺧿� ������
		sushiTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showSushiDetails(newValue));
		guestTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showGuestDetails(newValue));
		jumunTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showJumunDetails(newValue));
		storeTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showStoreDetails(newValue));
	}

	// ������ ���ξ� ȣ��-->�ݵ�� Main.java���� ȣ���ؾ���, Main�� ���� controller ���ٰ���
	// SushiController controller = loader.getController();
	// controller.setMainApp(this);
	public void setMain(Main main) {
		this.main = main;
		sushiTable.setItems(main.getSuchiVOData());
		guestTable.setItems(main.getGuestVOData());
		jumunTable.setItems(main.getJumunVOData());
		storeTable.setItems(main.getStoreVOData());
	}

	@FXML
	public void menuFront() {
		sushi1.toFront();
	}

	@FXML
	public void menuFront2() {
		sushi2.toFront();
	}

	@FXML
	public void menuFront3() {
		sushi3.toFront();
	}

	///////////////////////////////////////// â���� ��ư
	// ���ý� �ش� ������ ���� �����Բ��Ѵ�.
	public void showSushiDetails(SushiVO sushi) {
		if (sushi != null) {
			sushiNoLabel.setText(sushi.getSushiNo());
			sushiNameLabel.setText(sushi.getSushiName());
			sushiPriceLabel.setText(sushi.getSushiPrice());
			fishNoLabel.setText(sushi.getFishNo());
			fishNameLabel.setText(sushi.getFishName());
			fishInLabel.setText(sushi.getFishIn());
		} else {
			sushiNoLabel.setText("");
			sushiNameLabel.setText("");
			sushiPriceLabel.setText("");
			fishNoLabel.setText("");
			fishNameLabel.setText("");
			fishInLabel.setText("");
		}
	}

	// ���ý� �մ����� ������
	public void showGuestDetails(GuestVO guest) {
		if (guest != null) {
			guestNoLabelg.setText(guest.getGuestNo());
			tableNoLabelg.setText(guest.getTableNo());
		} else {
			guestNoLabelg.setText("");
			tableNoLabelg.setText("");
		}
	}

	// ���ý� �ֹ����� ������
	public void showJumunDetails(JumunVO jumun) {
		if (jumun != null) {
			jumunNoLabel.setText(jumun.getJumunNo());
			guestNoLabelj.setText(jumun.getGuestNo());
			tableNoLabelj.setText(jumun.getTableNo());
			sushiNoLabelj.setText(jumun.getSushiNo());
			sushiCountLabel.setText(jumun.getSushiCount());
		} else {
			jumunNoLabel.setText("");
			guestNoLabelj.setText("");
			tableNoLabelj.setText("");
			sushiNoLabelj.setText("");
			sushiCountLabel.setText("");
		}
	}

	// ���ý� ��������������
	public void showStoreDetails(StoreVO store) {
		if (store != null) {
			fishNoLabels.setText(store.getFishNo());
			fishAmountLabels.setText(store.getFishAmount());
		} else {
			fishNoLabels.setText("");
			fishAmountLabels.setText("");
		}
	}

	/////////////////////////////////////////////////////////////////////////// ��ư�̺�Ʈ����
	// ��ư�� Sushi.fxml�� �����Ƿ� ���⼭ �̺�Ʈ ó���ؾ��Ѵ�
	@FXML
	public void deleteSushi() {
		int selectedIndex = sushiTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			sushiTable.getItems().remove(selectedIndex);
			main.printList();
		}
	}

	@FXML
	public void newSushi() {
		SushiVO sushi = new SushiVO();
		boolean okClicked = main.showSushiDialog(sushi);
		if (okClicked) {
			main.getSuchiVOData().add(sushi);
			main.printList();
			// add�� �����ϴ���Ȯ���ϸ� ���ð� �߰��Ǵ��� Ȯ���غ� �� �ֳ�
		}
	}

	////////////////////////////////////////////////////////////////////////////////// controller����
	////////////////////////////////////////////////////////////////////////////////// �̺�Ʈ
	////////////////////////////////////////////////////////////////////////////////// �ɾ��ִ°�
	@FXML
	public void deleteGuest() {
		int selectedIndex = guestTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			guestTable.getItems().remove(selectedIndex);
			main.printList();
		}
	}

	@FXML
	public void newGuest() {
		GuestVO guest = new GuestVO();
		boolean okClicked = main.showGuestDialog(guest);
		if (okClicked) {
			main.getGuestVOData().add(guest);
			main.printList();
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	@FXML
	public void deleteJumun() {
		int selectedIndex = jumunTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			jumunTable.getItems().remove(selectedIndex);
			// main.printList();
		}
	}

	@FXML
	public void newJumun() {
		JumunVO jumun = new JumunVO();
		boolean okClicked = main.showJumunDialog(jumun);
		if (okClicked) {
			main.getJumunVOData().add(jumun);
			main.printList();
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	@FXML
	public void deleteStore() {
		int selectedIndex = storeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			storeTable.getItems().remove(selectedIndex);
			// main.printList();
		}
	}

	@FXML
	public void newStore() {
		StoreVO store = new StoreVO();
		boolean okClicked = main.showStoreDialog(store);
		if (okClicked) {
			main.getStoreVOData().add(store);
			main.printList();
		}
	}

}
