/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.DanhMuc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.BanHang;
import view.HoaDonView;
import view.KhuyenMai;
import view.KhachHang;
import view.NhanVienView;
import view.SanPham;
import view.ThongKe;

/**
 *
 * @author thong
 */
public class DanhMucRepository {

    private JPanel root;
    private String selected = "";

    private List<DanhMuc> listItem = null;

    public DanhMucRepository(JPanel jpnRoot) {
        root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        selected = "BanHang";
        jpnItem.setBackground(new Color(204, 204, 204));
        jlbItem.setBackground(Color.black);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new BanHang());
        root.validate();
        root.repaint();
        
    }

    public void setEvent(List<DanhMuc> list) {
        this.listItem = list;

        for (DanhMuc danhMuc : list) {
            danhMuc.getJlb().addMouseListener(new LabelEvent(danhMuc.getKind(), danhMuc.getJpn(), danhMuc.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "ThongKe":
                    node = new ThongKe();
                    break;
                case "BanHang":
                    node = new BanHang();
                    break;
                case "HoaDon":
                    node = new HoaDonView();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMai();
                    break;
                case "KhachHang":
                    node = new KhachHang();
                    break;
                case "NhanVien":
                    node = new NhanVienView();
                    break;
                case "SanPham":
                    node = new SanPham();
                    break;
                default:
                    break;

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            selected = kind;
            jpnItem.setBackground(new Color(204, 204, 204));
            jlbItem.setBackground(Color.black);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(204, 204, 204));
            jlbItem.setBackground(Color.black);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!selected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(248, 169, 50));
                jlbItem.setBackground(Color.black);
            }

        }

        private void setChangeBackground(String kind) {
            for (DanhMuc danhMuc : listItem) {
                if (danhMuc.getKind().equalsIgnoreCase(kind)) {
                    danhMuc.getJpn().setBackground(new Color(204, 204, 204));
                    danhMuc.getJlb().setBackground(Color.black);

                } else {
                    danhMuc.getJpn().setBackground(new Color(248, 169, 50));
                    danhMuc.getJlb().setBackground(Color.black);
                }
            }
        }

    }

}
