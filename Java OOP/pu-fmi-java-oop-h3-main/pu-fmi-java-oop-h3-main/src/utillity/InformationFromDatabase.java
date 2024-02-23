package utillity;

import structure.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import static java.awt.image.ImageObserver.WIDTH;

public class InformationFromDatabase{

    private BufferedReader in;
    private String line;
    private String filename = "database/online_shop_database.txt";
    private String encoding = "UTF-8";
    private DefaultMutableTreeNode top;
    private JTree tree;

    ArrayList<Category>categoriesList=new ArrayList<>();
    ArrayList<SubCategory>subCategoriesList=new ArrayList<>();
    ArrayList<Product>productsList=new ArrayList<>();

    Category category=new Category();
    SubCategory subCategory =new SubCategory();
    Shop shop=new Shop();
    Product product =new Product();


    String categoryName;
    String subCategoryName;
    String productName;


    //За да работи попълването на данните в таблицата, трябва първо да сме натиснали бутон количка и след това да си изберем елементите които ще се добавят, поне при мен така работи!
    public void createFrame() {

        JFrame mainFrame = new JFrame("Online shop Name");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 1000);

        mainFrame.add(getPanels());

        mainFrame.setVisible(true);
    }

    public Component getPanels() {
        return createMainPanel();
    }

    public JPanel panel = new JPanel();
    Border blackLine = BorderFactory.createLineBorder(Color.black);

    public Component createMainPanel() {

        panel.setLayout(new GridLayout(1, 4));
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        panel.add(createTitlePanel(), BorderLayout.NORTH);
        panel.add(createMenuPanel(), BorderLayout.WEST);
        panel.add(createContentPanel(), BorderLayout.CENTER);
        panel.add(createFooterPanel(), BorderLayout.SOUTH);

        return panel;
    }

    public Component createTitlePanel() {

        JPanel titlePanel = new JPanel();

        JLabel titleLabel = new JLabel("Online Shop Name");

        titlePanel.setBorder(blackLine);
        titlePanel.add(titleLabel);

        return titlePanel;

    }

    public Component createMenuPanel() {

        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(blackLine);

        menuPanel.add(getTree());

        return menuPanel;
    }

    public JPanel contentPanel = new JPanel();

    public Component createContentPanel() {

        contentPanel.setLayout(new GridLayout(5, 0));
        contentPanel.setBorder(blackLine);

        JLabel contentTittleLabel = new JLabel("Welcome !!!");
        JLabel contentLabel = new JLabel("Please, select a category");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;

        JPanel welcomeTitlePanel = new JPanel();
        welcomeTitlePanel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        welcomeTitlePanel.add(contentTittleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        welcomeTitlePanel.add(contentLabel, gbc);

        contentPanel.add(welcomeTitlePanel);
        contentPanel.add(new JLabel(" "));
        contentPanel.add(new JLabel(" "));
        contentPanel.add(new JLabel(" "));
        contentPanel.add(new JLabel(" "));
        return contentPanel;

    }

    public Component createFooterPanel() {

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new GridLayout(2, 4));
        JLabel footerLabel = new JLabel(" ");
        footerPanel.setBorder(blackLine);
        footerPanel.add(footerLabel);

        return footerPanel;

    }
    JTable jt=new JTable();
    JPanel shoppingCartPanel=new JPanel();

    JButton shoppingCart=new JButton("Количка");

    public Component createProductsTrousersPanel() throws IOException {
        JPanel productsPanel=new JPanel();
        JPanel product1Panel=new JPanel();
        JPanel product2Panel=new JPanel();

        JButton addJackAndJonesJeans1=new JButton("Добави");
        addJackAndJonesJeans1.addActionListener(e -> {
            int count =0;
            count+=1;

            addRowToJTable(
                    new Object[]{
                            createProductNameList().get(0).getBrand(),
                            count,
                            createProductNameList().get(0).getPrice(),
                            count*createProductNameList().get(0).getPrice(),
                    }
            );
        });

        JButton addChristianDiorPants=new JButton("Добави");
        addChristianDiorPants.addActionListener(e ->{
            int count =0;
            count+=1;
                addRowToJTable(
                new Object[]{
                        createProductNameList().get(1).getBrand(),
                        count,
                        createProductNameList().get(1).getPrice(),
                        count*createProductNameList().get(1).getPrice(),
                }
        );
                });
        productsPanel.setLayout(new GridLayout(1,1));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        product1Panel.setLayout(new GridBagLayout());
        product2Panel.setLayout(new GridBagLayout());

        contentPanel.removeAll();

        String trousersBrand=createProductNameList().get(0).getBrand();
        String trousersPrice= String.valueOf(createProductNameList().get(0).getPrice());
        String trousersQuantity=String.valueOf(createProductNameList().get(0).getQuantity());

        JLabel brandLabel=new JLabel(trousersBrand);
        JLabel priceLabel=new JLabel("Цена: "+trousersPrice+" лв.");
        JLabel quantityLabel=new JLabel("Налични бройки: " +trousersQuantity);


            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

        BufferedImage img = null;

        img = ImageIO.read(new File("photos/clothes/trousers/jack_and_jones_jeans_photo.jpeg"));
        JLabel picLabel = new JLabel(new ImageIcon(img));

        picLabel.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product1Panel.add(picLabel,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product1Panel.add(brandLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product1Panel.add(priceLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product1Panel.add(quantityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product1Panel.add(addJackAndJonesJeans1, gbc);

        String trousersBrand1=createProductNameList().get(1).getBrand();
        String trousersPrice1= String.valueOf(createProductNameList().get(1).getPrice());
        String trousersQuantity1= String.valueOf(createProductNameList().get(1).getQuantity());

        JLabel brandLabel1=new JLabel(trousersBrand1);
        JLabel priceLabel1=new JLabel("Цена: "+trousersPrice1+" лв.");
        JLabel quantityLabel1=new JLabel("Налични бройки: " +trousersQuantity1);

        img = ImageIO.read(new File("photos/clothes/trousers/christian_dior_pants_photo.jpeg"));
        JLabel picLabel1 = new JLabel(new ImageIcon(img));

        picLabel1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product2Panel.add(picLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product2Panel.add(brandLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product2Panel.add(priceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product2Panel.add(quantityLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product2Panel.add(addChristianDiorPants, gbc);

        productsPanel.add(product1Panel);
        productsPanel.add(product2Panel);

        shoppingCartPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        shoppingCart.addActionListener(new ShowItemsFromShoppingCart());
        shoppingCartPanel.add(shoppingCart,gbc);

        contentPanel.add(productsPanel);
        contentPanel.add(shoppingCartPanel);

        return contentPanel;
    }

    public Component createProductsTShirtPanel() throws IOException {
        JPanel productsPanel=new JPanel();
        JPanel product1Panel=new JPanel();
        JPanel product2Panel=new JPanel();

        JButton addJackAndJonesTShirt=new JButton("Добави");
        addJackAndJonesTShirt.addActionListener(e ->{
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(2).getBrand(),
                        count,
                        createProductNameList().get(2).getPrice(),
                        count*createProductNameList().get(2).getPrice(),
                    });
                });
        JButton addChristianDiorTShirt=new JButton("Добави");
        addChristianDiorTShirt.addActionListener(e ->{
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(3).getBrand(),
                        count,
                        createProductNameList().get(3).getPrice(),
                       count*createProductNameList().get(3).getPrice(),
                }
        );
                });

        contentPanel.removeAll();

        productsPanel.setLayout(new GridLayout(1,1));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        product1Panel.setLayout(new GridBagLayout());
        product2Panel.setLayout(new GridBagLayout());

        String tShirtBrand=createProductNameList().get(2).getBrand();
        String tShirtPrice= String.valueOf(createProductNameList().get(2).getPrice());
        String tShirtQuantity= String.valueOf(createProductNameList().get(2).getQuantity());

        JLabel brandLabel=new JLabel(tShirtBrand);
        JLabel priceLabel=new JLabel("Цена: "+tShirtPrice+" лв.");

        JLabel quantityLabel=new JLabel("Налични бройки: " +tShirtQuantity);

        BufferedImage img = null;

        img = ImageIO.read(new File("photos/clothes/t_shirts/jack_and_jones_t-shirt_photo.jpeg"));
        JLabel picLabel = new JLabel(new ImageIcon(img));

        picLabel.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product1Panel.add(picLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product1Panel.add(brandLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product1Panel.add(priceLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        product1Panel.add(quantityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product1Panel.add(addJackAndJonesTShirt, gbc);

        String tShirtBrand1=createProductNameList().get(3).getBrand();
        String tShirtPrice1= String.valueOf(createProductNameList().get(3).getPrice());
        String tShirtQuantity1= String.valueOf(createProductNameList().get(3).getQuantity());

        JLabel brandLabel1=new JLabel(tShirtBrand1);
        JLabel priceLabel1=new JLabel("Цена: "+tShirtPrice1+" лв.");
        JLabel quantityLabel1=new JLabel("Налични бройки: " +tShirtQuantity1);

        img = ImageIO.read(new File("photos/clothes/t_shirts/christian_dior_t-shirt_photo.png"));
        JLabel picLabel1 = new JLabel(new ImageIcon(img));

        picLabel1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product2Panel.add(picLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product2Panel.add(brandLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product2Panel.add(priceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product2Panel.add(quantityLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product2Panel.add(addChristianDiorTShirt, gbc);

        productsPanel.add(product1Panel);
        productsPanel.add(product2Panel);

        shoppingCartPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        shoppingCart.addActionListener(new ShowItemsFromShoppingCart());
        shoppingCartPanel.add(shoppingCart,gbc);

        contentPanel.add(productsPanel);
        contentPanel.add(shoppingCartPanel);

        return contentPanel;
    }

    public Component createProductJacketsPanel() throws IOException {
        JPanel productsPanel=new JPanel();
        JPanel product1Panel=new JPanel();
        JPanel product2Panel=new JPanel();

        JButton addBurberryJacket=new JButton("Добави");
        addBurberryJacket.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(4).getBrand(),
                        count,
                        createProductNameList().get(4).getPrice(),
                        count*createProductNameList().get(4).getPrice(),
                }
        );
                });

        JButton addChristianDiorJacket=new JButton("Добави");
        addChristianDiorJacket.addActionListener(e ->{
            int count =0;
            count+=1;

            addRowToJTable(
                new Object[]{
                        createProductNameList().get(5).getBrand(),
                        count,
                        createProductNameList().get(5).getPrice(),
                        count*createProductNameList().get(5).getPrice(),
                }
        );
                });
        contentPanel.removeAll();

        productsPanel.setLayout(new GridLayout(1,1));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        product1Panel.setLayout(new GridBagLayout());
        product2Panel.setLayout(new GridBagLayout());

        String jacketsBrand=createProductNameList().get(4).getBrand();
        String jacketsPrice= String.valueOf(createProductNameList().get(4).getPrice());
        String jacketsQuantity= String.valueOf(createProductNameList().get(4).getQuantity());

        JLabel brandLabel=new JLabel(jacketsBrand);
        JLabel priceLabel=new JLabel("Цена: "+jacketsPrice+" лв.");
        JLabel quantityLabel=new JLabel("Налични бройки: " +jacketsQuantity);

        BufferedImage img = null;

        img = ImageIO.read(new File("photos/clothes/jackets/burberry_jacket_photo.jpeg"));
        JLabel picLabel = new JLabel(new ImageIcon(img));

        picLabel.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product1Panel.add(picLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product1Panel.add(brandLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product1Panel.add(priceLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        product1Panel.add(quantityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product1Panel.add(addBurberryJacket, gbc);

        String jacketsBrand1=createProductNameList().get(5).getBrand();
        String jacketsPrice1= String.valueOf(createProductNameList().get(5).getPrice());
        String jacketsQuantity1= String.valueOf(createProductNameList().get(5).getQuantity());

        JLabel brandLabel1=new JLabel(jacketsBrand1);
        JLabel priceLabel1=new JLabel("Цена: "+jacketsPrice1+" лв.");
        JLabel quantityLabel1=new JLabel("Налични бройки: " +jacketsQuantity1);

        img = ImageIO.read(new File("photos/clothes/jackets/christian_dior_jacket_photo.jpeg"));
        JLabel picLabel1 = new JLabel(new ImageIcon(img));

        picLabel1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product2Panel.add(picLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product2Panel.add(brandLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product2Panel.add(priceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product2Panel.add(quantityLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product2Panel.add(addChristianDiorJacket, gbc);

        productsPanel.add(product1Panel);
        productsPanel.add(product2Panel);

        shoppingCartPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        shoppingCart.addActionListener(new ShowItemsFromShoppingCart());
        shoppingCartPanel.add(shoppingCart,gbc);

        contentPanel.add(productsPanel);
        contentPanel.add(shoppingCartPanel);

        return contentPanel;
    }

    public Component createProductNotebooksPanel() throws IOException {
        JPanel productsPanel=new JPanel();
        JPanel product1Panel=new JPanel();
        JPanel product2Panel=new JPanel();
        JPanel product3Panel=new JPanel();

        JButton addAcerAspire=new JButton("Добави");
        addAcerAspire.addActionListener(e ->{
            int count =0;
            count+=1;

            addRowToJTable(
                new Object[]{
                        createProductNameList().get(6).getBrand(),
                        count,
                        createProductNameList().get(6).getPrice(),
                       count*createProductNameList().get(6).getPrice(),
                }
        );
                });

        JButton addLenovo=new JButton("Добави");
        addLenovo.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(7).getBrand(),
                        count,
                        createProductNameList().get(7).getPrice(),
                        count*createProductNameList().get(7).getPrice(),
                }
        );
                });
        JButton addAcerAspire3=new JButton("Добави");
        addAcerAspire3.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(8).getBrand(),
                        count,
                        createProductNameList().get(8).getPrice(),
                        count*createProductNameList().get(8).getPrice(),
                }
        );
                });
        contentPanel.removeAll();

        productsPanel.setLayout(new GridLayout(1,1));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        product1Panel.setLayout(new GridBagLayout());
        product2Panel.setLayout(new GridBagLayout());
        product3Panel.setLayout(new GridBagLayout());

        String notebooksBrand=createProductNameList().get(6).getBrand();
        String notebooksPrice= String.valueOf(createProductNameList().get(6).getPrice());
        String notebooksQuantity= String.valueOf(createProductNameList().get(6).getQuantity());

        JLabel brandLabel=new JLabel(notebooksBrand);
        JLabel priceLabel=new JLabel("Цена: "+notebooksPrice+" лв.");
        JLabel quantityLabel=new JLabel("Налични бройки: " +notebooksQuantity);

        BufferedImage img = null;

        img = ImageIO.read(new File("photos/electronics/notebooks/acer_aspire_5750G_photo.jpeg"));
        JLabel picLabel = new JLabel(new ImageIcon(img));

        picLabel.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product1Panel.add(picLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product1Panel.add(brandLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product1Panel.add(priceLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        product1Panel.add(quantityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product1Panel.add(addAcerAspire, gbc);

        String notebooksBrand1=createProductNameList().get(7).getBrand();
        String notebooksPrice1= String.valueOf(createProductNameList().get(7).getPrice());
        String notebooksQuantity1= String.valueOf(createProductNameList().get(7).getQuantity());

        JLabel brandLabel1=new JLabel(notebooksBrand1);
        JLabel priceLabel1=new JLabel("Цена: "+notebooksPrice1+" лв.");
        JLabel quantityLabel1=new JLabel("Налични бройки: " +notebooksQuantity1);

        img = ImageIO.read(new File("photos/electronics/notebooks/lenovo_v13015igm_photo.jpeg"));
        JLabel picLabel1 = new JLabel(new ImageIcon(img));

        picLabel1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product2Panel.add(picLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product2Panel.add(brandLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product2Panel.add(priceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product2Panel.add(quantityLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product2Panel.add(addLenovo, gbc);

        String notebooksBrand2=createProductNameList().get(8).getBrand();
        String notebooksPrice2= String.valueOf(createProductNameList().get(8).getPrice());
        String notebooksQuantity2= String.valueOf(createProductNameList().get(8).getQuantity());

        JLabel brandLabel2=new JLabel(notebooksBrand2);
        JLabel priceLabel2=new JLabel("Цена: "+notebooksPrice2+" лв.");
        JLabel quantityLabel2=new JLabel("Налични бройки: " +notebooksQuantity2);

        img = ImageIO.read(new File("photos/electronics/notebooks/acer_aspire_3.jpeg"));
        JLabel picLabel2 = new JLabel(new ImageIcon(img));

        picLabel2.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product3Panel.add(picLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product3Panel.add(brandLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product3Panel.add(priceLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product3Panel.add(quantityLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product3Panel.add(addAcerAspire3, gbc);

        productsPanel.add(product1Panel);
        productsPanel.add(product2Panel);
        productsPanel.add(product3Panel);

        shoppingCartPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        shoppingCart.addActionListener(new ShowItemsFromShoppingCart());
        shoppingCartPanel.add(shoppingCart,gbc);

        contentPanel.add(productsPanel);
        contentPanel.add(shoppingCartPanel);

        return contentPanel;
    }

    public Component createProductSmartphonesPanel() throws IOException {
        JPanel productsPanel=new JPanel();
        JPanel product1Panel=new JPanel();
        JPanel product2Panel=new JPanel();
        JPanel product3Panel=new JPanel();

        JButton addSamsung=new JButton("Добави");
        addSamsung.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                    new Object[]{
                            createProductNameList().get(9).getBrand(),
                            count,
                            createProductNameList().get(9).getPrice(),
                            count*createProductNameList().get(9).getPrice(),
                    }
            );
        });

        JButton addLG=new JButton("Добави");
        addLG.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                new Object[]{
                        createProductNameList().get(10).getBrand(),
                        count,
                        createProductNameList().get(10).getPrice(),
                        count*createProductNameList().get(10).getPrice(),
                }
        );
                });
        JButton addXiaomi=new JButton("Добави");
        addXiaomi.addActionListener(e -> {
            int count =0;
            count+=1;
            addRowToJTable(
                    new Object[]{
                            createProductNameList().get(11).getBrand(),
                            count,
                            createProductNameList().get(11).getPrice(),
                            count*createProductNameList().get(11).getPrice(),
                    }
            );
        });

        contentPanel.removeAll();

        productsPanel.setLayout(new GridLayout(1,1));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        product1Panel.setLayout(new GridBagLayout());
        product2Panel.setLayout(new GridBagLayout());
        product3Panel.setLayout(new GridBagLayout());

        String smartphonesBrand=createProductNameList().get(9).getBrand();
        String smartphonesPrice= String.valueOf(createProductNameList().get(9).getPrice());
        String smartphonesQuantity= String.valueOf(createProductNameList().get(9).getQuantity());

        JLabel brandLabel=new JLabel(smartphonesBrand);
        JLabel priceLabel=new JLabel("Цена: "+smartphonesPrice+" лв.");
        JLabel quantityLabel=new JLabel("Налични бройки: " +smartphonesQuantity);

        BufferedImage img = null;

        img = ImageIO.read(new File("photos/electronics/smartphones/samsung_galaxy-s9_photo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(img));

        picLabel.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product1Panel.add(picLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product1Panel.add(brandLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product1Panel.add(priceLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        product1Panel.add(quantityLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product1Panel.add(addSamsung, gbc);

        String smartphonesBrand1=createProductNameList().get(10).getBrand();
        String smartphonesPrice1= String.valueOf(createProductNameList().get(10).getPrice());
        String smartphonesQuantity1= String.valueOf(createProductNameList().get(10).getQuantity());

        JLabel brandLabel1=new JLabel(smartphonesBrand1);
        JLabel priceLabel1=new JLabel("Цена: "+smartphonesPrice1+" лв.");
        JLabel quantityLabel1=new JLabel("Налични бройки: " +smartphonesQuantity1);

        img = ImageIO.read(new File("photos/electronics/smartphones/lg_g5_photo.jpeg"));
        JLabel picLabel1 = new JLabel(new ImageIcon(img));

        picLabel1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product2Panel.add(picLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product2Panel.add(brandLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product2Panel.add(priceLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product2Panel.add(quantityLabel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product2Panel.add(addLG, gbc);

        String smartphonesBrand2=createProductNameList().get(11).getBrand();
        String smartphonesPrice2= String.valueOf(createProductNameList().get(11).getPrice());
        String smartphonesQuantity2= String.valueOf(createProductNameList().get(11).getQuantity());

        JLabel brandLabel2=new JLabel(smartphonesBrand2);
        JLabel priceLabel2=new JLabel("Цена: "+smartphonesPrice2+" лв.");
        JLabel quantityLabel2=new JLabel("Налични бройки: " +smartphonesQuantity2);

        img = ImageIO.read(new File("photos/electronics/smartphones/xiaomi_redmi_note_5_pro_photo.jpeg"));
        JLabel picLabel2 = new JLabel(new ImageIcon(img));

        picLabel2.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(60,60,WIDTH)));

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        product3Panel.add(picLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        product3Panel.add(brandLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        product3Panel.add(priceLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        product3Panel.add(quantityLabel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        product3Panel.add(addXiaomi, gbc);

        productsPanel.add(product1Panel);
        productsPanel.add(product2Panel);
        productsPanel.add(product3Panel);

        shoppingCartPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        shoppingCart.addActionListener(new ShowItemsFromShoppingCart());
        shoppingCartPanel.add(shoppingCart,gbc);

        contentPanel.add(productsPanel);
        contentPanel.add(shoppingCartPanel);

        return contentPanel;
    }

    public JDialog createDialog(JFrame frame){

        JDialog modelDialog = new JDialog(frame, "Количка", Dialog.ModalityType.DOCUMENT_MODAL);
        modelDialog.setBounds(132, 132, 300, 200);

        Container dialogContainer = modelDialog.getContentPane();

        dialogContainer.setLayout(new BorderLayout());

        dialogContainer.add(table());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        JButton payViaCard = new JButton("Pay via Card");
        JButton payViaPayPal = new JButton("Pay via PayPal");

        payViaCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                saveOrderAsText();

            }
        });

        payViaPayPal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelDialog.setVisible(false);
                saveOrderAsText();
            }
        });

        panel1.add(payViaCard);
        panel1.add(payViaPayPal);
        dialogContainer.add(panel1, BorderLayout.SOUTH);

        modelDialog.setVisible(true);
        return modelDialog;
    }

    public void saveOrderAsText(){

        try{

            File file = new File("Text.txt ");

            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);


            for(int i = 0; i < jt.getRowCount(); i++){

                for(int j = 0; j < jt.getColumnCount(); j++){
                    bw.write(jt.getModel().getValueAt(i, j)+" ");
                }

                bw.write("\n");
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Транзакцията е успешна! Благодарим, че пазарувахте при нас!");

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public JScrollPane table(){

        String header[]=new String[]{"Име на продукта","Количество","Цена","Общо"};
        DefaultTableModel dtm = new DefaultTableModel(header,0);
        int row,col;

        jt.setModel(dtm);

        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        return sp;
    }

    public void addRowToJTable(Object[] dataRow){
        DefaultTableModel model =(DefaultTableModel)jt.getModel();

        model.addRow(dataRow);
    }

    public class ShowItemsFromShoppingCart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            createDialog(new JFrame());
        }
    }

    public InformationFromDatabase() {

        top = new DefaultMutableTreeNode();
        createNodes(top);

        tree = new JTree(top);
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }

        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        renderer.setLeafIcon(null);
        renderer.setClosedIcon(null);
        renderer.setOpenIcon(null);

        tree.addMouseListener(new ShowProduct());
        tree.setRootVisible(false);

    }

    private int countOccurrences(String haystack, char needle) {
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }

    DefaultMutableTreeNode categoryTreeNode = null;
    DefaultMutableTreeNode subCategoryTreeNode = null;

    public void createNodes(DefaultMutableTreeNode top) {

        try {

            in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename), encoding));

            while ((line= in.readLine()) != null) {

                if (countOccurrences(line, '<') == 1 &&countOccurrences(line,'/')!=1) {
                     categoryName = line.replaceAll("[<->]","");

                     createCategoryNameList();

                     categoryTreeNode = new DefaultMutableTreeNode(categoryName);

                     top.add(categoryTreeNode);


                } else if (countOccurrences(line,'_') == 1 ) {
                    subCategoryName = line.replace("_","");

                    createSubCategoryNameList();

                    subCategoryTreeNode = new DefaultMutableTreeNode(subCategoryName);
                    categoryTreeNode.add(subCategoryTreeNode);


                } else if (countOccurrences(line, '*') == 1) {
                    productName= line.replace("*","");

                    String[] matches= productName.split(",");

                    String productBrand = matches[0];
                    double productPrice= Double.parseDouble(matches[1]);
                    String productImage=matches[2];
                    int productQuantity= Integer.parseInt(matches[3]);

                    product.setBrand(productBrand);
                    product.setPrice(Double.parseDouble(String.valueOf(productPrice)));
                    product.setImageLocation(productImage);
                    product.setQuantity(productQuantity);

                    createProductNameList();

                }
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createCategoryNameList() {
         category.setName(categoryName);
        categoriesList.add(category);
        shop.setCategories(categoriesList);

        ArrayList<Category> newList = new ArrayList<>();
        for (Category element : categoriesList) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }
    }

    public void createSubCategoryNameList(){

        subCategory.setName(subCategoryName);
        subCategoriesList.add(subCategory);
        category.setSubCategoriesList(subCategoriesList);

        ArrayList<SubCategory> newList = new ArrayList<>();
        for (SubCategory element : subCategoriesList) {

            if (!newList.contains(element)) {

                newList.add(element);

            }
        }
    }

    public ArrayList<Product> createProductNameList(){

        productsList.add(createProduct());

        ArrayList<Product> newProductList=new ArrayList<>();

        for (Product element : productsList) {

            if (!newProductList.contains(element)) {

                newProductList.add(element);

            }
        }
            return newProductList;
    }

    public Product createProduct(){
        return new Product(product.getBrand(),product.getPrice(),product.getImageLocation(),product.getQuantity());
    }

    //За да работят бутоните за добавяне на артилул, трябва да се натисне около 4-5 пъти подкатегорията, поне при мен така работи!
        public class ShowProduct implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2) {

                    TreePath path = tree.getLeadSelectionPath();

                    if (path.getPathComponent(2).toString().trim().equals("trousers")) {
                        contentPanel.removeAll();
                        try {
                            createProductsTrousersPanel();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (path.getPathComponent(2).toString().trim().equals("T-shirts")) {
                        contentPanel.removeAll();
                        try {
                            createProductsTShirtPanel();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (path.getPathComponent(2).toString().trim().equals("jackets")) {
                        try {
                            createProductJacketsPanel();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (path.getPathComponent(2).toString().trim().equals("notebooks")) {
                        try {
                            createProductNotebooksPanel();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (path.getPathComponent(2).toString().trim().equals("smartphones")) {
                        try {
                            createProductSmartphonesPanel();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }

    public JTree getTree() {
        return tree;
    }
}



