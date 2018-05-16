package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.view.SushiController;
import main.view.SushiDialogController;
import main.vo.GuestVO;
import main.vo.JumunVO;
import main.vo.StoreVO;
import main.vo.SushiVO;

public class Main extends Application {

	private Stage primaryStage;
	private Stage dialogStage;
	
	
	private BorderPane rootLayout;
	private AnchorPane sushi;
	private AnchorPane sushidialog;
	private AnchorPane guestdialog;
	private AnchorPane jumundialog;
	private AnchorPane storedialog;
	// data ObservableList
	private ObservableList<SushiVO> sushiData = FXCollections.observableArrayList();
	private ObservableList<GuestVO> guestData = FXCollections.observableArrayList();
	private ObservableList<JumunVO> jumunData = FXCollections.observableArrayList();
	private ObservableList<StoreVO> storeData = FXCollections.observableArrayList();
	//
	public ObservableList<SushiVO> getSuchiVOData() {
		return sushiData;
	}
	public ObservableList<GuestVO> getGuestVOData(){
		return guestData;
	}
	public ObservableList<JumunVO> getJumunVOData(){
		return jumunData;
	}
	public ObservableList<StoreVO> getStoreVOData(){
		return storeData;
	}
	//
	public void printList() {//������ ���
		System.out.println(sushiData);
		System.out.println(guestData);
		System.out.println(jumunData);
		System.out.println(storeData);
	}
	
	public Main() {
		//�ʱⰪ����
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SunooshiMasteR!");

		initRootLayout();

		showSushi();
	}

	// ���̾ƿ� �ʱ�ȭ
	public void initRootLayout() {
		try {
			// fxml��������
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	// Menu�����ֱ�
	public void showSushi() {//��üâ �ҷ�����
		try {
			// �޴����� ��������
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Sushi.fxml"));
			sushi = (AnchorPane) loader.load();////////////////////
			// ���̾ƿ� ��ġ����
			rootLayout.setCenter(sushi);
			
			//controller�����ϱ�
			SushiController controller = loader.getController();
			controller.setMain(this);//fxml �������� ��� ĿƮ�ѷ� �ɾ��ֱ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean showSushiDialog(SushiVO sushi) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SushiDialog.fxml"));
			sushidialog = (AnchorPane) loader.load();
			//���̾�α׿� �������� �׸��� �׾ȿ� �� scene�������
			dialogStage = new Stage();
			dialogStage.setTitle("Sushi Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(sushidialog);
			dialogStage.setScene(scene);
			//��Ʈ�ѷ� �����ϱ�
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSushi(sushi);
			
			dialogStage.showAndWait();
			return controller.isOkClicked();//ok�Ǹ� Ʈ��ǰ� â����
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showGuestDialog(GuestVO guest) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GuestDialog.fxml"));
			guestdialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Guest Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(guestdialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setGuest(guest);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean showJumunDialog(JumunVO jumun) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/JumunDialog.fxml"));
			jumundialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Jumun Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(jumundialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setJumun(jumun);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showStoreDialog(StoreVO store) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/StoreDialog.fxml"));
			storedialog = (AnchorPane) loader.load();
			dialogStage = new Stage();
			dialogStage.setTitle("Store Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(storedialog);
			dialogStage.setScene(scene);
			SushiDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setStore(store);
			dialogStage.showAndWait();
			return controller.isOkClicked();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//////////////////////////////////////////////////////////////////
	//�߰� FXML�ۼ��� ��
	
	
/////////////////////////////////////////////////////////////////stageȣ��
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
