package com.mrjaffesclass.apcs.mvc.template;
import com.mrjaffesclass.apcs.messenger.*;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Point;
/**
 * MVC Template
 * This is a template of an MVC framework used by APCS for the 
 * LandMine project (and others)
 * @author Roger Jaffe
 * @version 1.0
 * 
 */
public class View extends javax.swing.JFrame implements MessageHandler {

  private final Messenger mvcMessaging;
  
  /**
   * Creates a new view
   * @param messages mvcMessaging object
   */
  public View(Messenger messages) {
    mvcMessaging = messages;   // Save the calling controller instance
    initComponents();           // Create and init the GUI components
    

  }
  
  JButton[] button = new JButton[65];
  JButton[][] buttons = new JButton[8][8];
  
  /**
   * Initialize the model here and subscribe
   * to any required messages
   */
  public void init() {
    // Subscribe to messages here
    mvcMessaging.subscribe("model:BOMB!", this);
    mvcMessaging.subscribe("model:safe", this);
    mvcMessaging.subscribe("model:liveschanged", this);
    mvcMessaging.subscribe("model:scorechanged", this);
    buttons[0][0] = aa;
    buttons[0][1] = ab;
    buttons[0][2] = ac;
    buttons[0][3]= ad;
    buttons[0][4] = ae;
    buttons[0][5] = af;
    buttons[0][6] = ag;
    buttons[0][7] = ah;
    buttons[1][0] = ba;
    buttons[1][1] = bb;
    buttons[1][2] = bc;
    buttons[1][3] = bd;
    buttons[1][4] = be;
    buttons[1][5] = bf;
    buttons[1][6] = bg;
    buttons[1][7] = bh;
    buttons[2][0] = ca;
    buttons[2][1] = cb;
    buttons[2][2] = cc;
    buttons[2][3] = cd;
    buttons[2][4] = ce;
    buttons[2][5] = cf;
    buttons[2][6] = cg;
    buttons[2][7] = ch;
    buttons[3][0] = da;
    buttons[3][1] = db;
    buttons[3][2] = dc;
    buttons[3][3] = dd;
    buttons[3][4] = de;
    buttons[3][5] = df;
    buttons[3][6] = dg;
    buttons[3][7] = dh;
    buttons[4][0] = ea;
    buttons[4][1] = eb;
    buttons[4][2] = ec;
    buttons[4][3] = ed;
    buttons[4][4] = ee;
    buttons[4][5] = ef;
    buttons[4][6] = eg;
    buttons[4][7] = eh;
    buttons[5][0] = fa;
    buttons[5][1] = fb;
    buttons[5][2] = fc;
    buttons[5][3] = fd;
    buttons[5][4] = fe;
    buttons[5][5] = ff;
    buttons[5][6] = fg;
    buttons[5][7] = fh;
    buttons[6][0] = ga;
    buttons[6][1] = gb;
    buttons[6][2] = gc;
    buttons[6][3] = gd;
    buttons[6][4] = ge;
    buttons[6][5] = gf;
    buttons[6][6] = gg;
    buttons[6][7] = gh;
    buttons[7][0] = ha;
    buttons[7][1] = hb;
    buttons[7][2] = hc;
    buttons[7][3] = hd;
    buttons[7][4] = he;
    buttons[7][5] = hf;
    buttons[7][6] = hg;
    buttons[7][7] = hh;
    button[1] = aa;
    button[2] = ab;
    button[3] = ac;
    button[4] = ad;
    button[5] = ae;
    button[6] = af;
    button[7] = ag;
    button[8] = ah;
    button[9] = ba;
    button[10] = bb;
    button[11] = bc;
    button[12] = bd;
    button[13] = be;
    button[14] = bf;
    button[15] = bg;
    button[16] = bh;
    button[17] = ca;
    button[18] = cb;
    button[19] = cc;
    button[20] = cd;
    button[21] = ce;
    button[22] = cf;
    button[23] = cg;
    button[24] = ch;
    button[25] = da;
    button[26] = db;
    button[27] = dc;
    button[28] = dd;
    button[29] = de;
    button[30] = df;
    button[31] = dg;
    button[32] = dh;
    button[33] = ea;
    button[34] = eb;
    button[35] = ec;
    button[36] = ed;
    button[37] = ee;
    button[38] = ef;
    button[39] = eg;
    button[40] = eh;
    button[41] = fa;
    button[42] = fb;
    button[43] = fc;
    button[44] = fd;
    button[45] = fe;
    button[46] = ff;
    button[47] = fg;
    button[48] = fh;
    button[49] = ga;
    button[50] = gb;
    button[51] = gc;
    button[52] = gd;
    button[53] = ge;
    button[54] = gf;
    button[55] = gg;
    button[56] = gh;
    button[57] = ha;
    button[58] = hb;
    button[59] = hc;
    button[60] = hd;
    button[61] = he;
    button[62] = hf;
    button[63] = hg;
    button[64] = hh;
  }
   public Point findButton(JButton thisWasClicked)
  {
      Point foundIt = null;
      for (int row = 0; row < 8; row++)
      {
          for (int col = 0; col < 8; col++)
          {
          if(thisWasClicked.equals(buttons[row][col]))
                  {
                      foundIt = new Point(row, col);
                  }          
          }
      }
      return foundIt;
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("RCV (view): "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("RCV (view): "+messageName+" | No data sent");
    }
    if (messageName.equals("model:liveschanged"))
    {
     jLabel2.setText(messagePayload.toString());   
    }  
    else if (messageName.equals("model:scorechanged"))
    {
     jLabel4.setText(messagePayload.toString());   
    }
    else if (messageName.equals("model:BOMB!"))
    {
     int b = Integer.parseInt(messagePayload.toString());
     button[b].setBackground(Color.red);     
     jLabel5.setVisible(true);
    }    
    else if (messageName.equals("model:safe"))
    {
     int c = Integer.parseInt(messagePayload.toString());
     button[c].setBackground(Color.blue);
    }    
  }
  
    private MessagePayload createPayload(int number, boolean mine) {
    MessagePayload payload = new MessagePayload(number, mine);
    return payload;
  }
 
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aa = new javax.swing.JButton();
        ab = new javax.swing.JButton();
        ac = new javax.swing.JButton();
        ad = new javax.swing.JButton();
        ae = new javax.swing.JButton();
        af = new javax.swing.JButton();
        ag = new javax.swing.JButton();
        ah = new javax.swing.JButton();
        ba = new javax.swing.JButton();
        bb = new javax.swing.JButton();
        bc = new javax.swing.JButton();
        bd = new javax.swing.JButton();
        be = new javax.swing.JButton();
        bf = new javax.swing.JButton();
        bg = new javax.swing.JButton();
        bh = new javax.swing.JButton();
        ca = new javax.swing.JButton();
        cb = new javax.swing.JButton();
        cc = new javax.swing.JButton();
        cd = new javax.swing.JButton();
        ce = new javax.swing.JButton();
        cf = new javax.swing.JButton();
        cg = new javax.swing.JButton();
        ch = new javax.swing.JButton();
        da = new javax.swing.JButton();
        db = new javax.swing.JButton();
        dc = new javax.swing.JButton();
        dd = new javax.swing.JButton();
        de = new javax.swing.JButton();
        df = new javax.swing.JButton();
        dg = new javax.swing.JButton();
        dh = new javax.swing.JButton();
        ea = new javax.swing.JButton();
        eb = new javax.swing.JButton();
        ec = new javax.swing.JButton();
        ed = new javax.swing.JButton();
        ee = new javax.swing.JButton();
        ef = new javax.swing.JButton();
        eg = new javax.swing.JButton();
        eh = new javax.swing.JButton();
        fa = new javax.swing.JButton();
        fb = new javax.swing.JButton();
        fc = new javax.swing.JButton();
        fd = new javax.swing.JButton();
        fe = new javax.swing.JButton();
        ff = new javax.swing.JButton();
        fg = new javax.swing.JButton();
        fh = new javax.swing.JButton();
        ga = new javax.swing.JButton();
        gb = new javax.swing.JButton();
        gc = new javax.swing.JButton();
        gd = new javax.swing.JButton();
        ge = new javax.swing.JButton();
        gf = new javax.swing.JButton();
        gg = new javax.swing.JButton();
        gh = new javax.swing.JButton();
        ha = new javax.swing.JButton();
        hb = new javax.swing.JButton();
        hc = new javax.swing.JButton();
        hd = new javax.swing.JButton();
        he = new javax.swing.JButton();
        hf = new javax.swing.JButton();
        hg = new javax.swing.JButton();
        hh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aa.setText("Click Me!");
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });

        ab.setText("Click Me!");
        ab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abActionPerformed(evt);
            }
        });

        ac.setText("Click Me!");
        ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acActionPerformed(evt);
            }
        });

        ad.setText("Click Me!");
        ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adActionPerformed(evt);
            }
        });

        ae.setText("Click Me!");
        ae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aeActionPerformed(evt);
            }
        });

        af.setText("Click Me!");
        af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afActionPerformed(evt);
            }
        });

        ag.setText("Click Me!");
        ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agActionPerformed(evt);
            }
        });

        ah.setText("Click Me!");
        ah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ahActionPerformed(evt);
            }
        });

        ba.setText("Click Me!");
        ba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baActionPerformed(evt);
            }
        });

        bb.setText("Click Me!");
        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });

        bc.setText("Click Me!");
        bc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcActionPerformed(evt);
            }
        });

        bd.setText("Click Me!");
        bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdActionPerformed(evt);
            }
        });

        be.setText("Click Me!");
        be.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beActionPerformed(evt);
            }
        });

        bf.setText("Click Me!");
        bf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfActionPerformed(evt);
            }
        });

        bg.setText("Click Me!");
        bg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgActionPerformed(evt);
            }
        });

        bh.setText("Click Me!");
        bh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhActionPerformed(evt);
            }
        });

        ca.setText("Click Me!");
        ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caActionPerformed(evt);
            }
        });

        cb.setText("Click Me!");
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        cc.setText("Click Me!");
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });

        cd.setText("Click Me!");
        cd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdActionPerformed(evt);
            }
        });

        ce.setText("Click Me!");
        ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceActionPerformed(evt);
            }
        });

        cf.setText("Click Me!");
        cf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfActionPerformed(evt);
            }
        });

        cg.setText("Click Me!");
        cg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgActionPerformed(evt);
            }
        });

        ch.setText("Click Me!");
        ch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActionPerformed(evt);
            }
        });

        da.setText("Click Me!");
        da.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daActionPerformed(evt);
            }
        });

        db.setText("Click Me!");
        db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbActionPerformed(evt);
            }
        });

        dc.setText("Click Me!");
        dc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcActionPerformed(evt);
            }
        });

        dd.setText("Click Me!");
        dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddActionPerformed(evt);
            }
        });

        de.setText("Click Me!");
        de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deActionPerformed(evt);
            }
        });

        df.setText("Click Me!");
        df.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfActionPerformed(evt);
            }
        });

        dg.setText("Click Me!");
        dg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dgActionPerformed(evt);
            }
        });

        dh.setText("Click Me!");
        dh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dhActionPerformed(evt);
            }
        });

        ea.setText("Click Me!");
        ea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eaActionPerformed(evt);
            }
        });

        eb.setText("Click Me!");
        eb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebActionPerformed(evt);
            }
        });

        ec.setText("Click Me!");
        ec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecActionPerformed(evt);
            }
        });

        ed.setText("Click Me!");
        ed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edActionPerformed(evt);
            }
        });

        ee.setText("Click Me!");
        ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eeActionPerformed(evt);
            }
        });

        ef.setText("Click Me!");
        ef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efActionPerformed(evt);
            }
        });

        eg.setText("Click Me!");
        eg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                egActionPerformed(evt);
            }
        });

        eh.setText("Click Me!");
        eh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ehActionPerformed(evt);
            }
        });

        fa.setText("Click Me!");
        fa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faActionPerformed(evt);
            }
        });

        fb.setText("Click Me!");
        fb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbActionPerformed(evt);
            }
        });

        fc.setText("Click Me!");
        fc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcActionPerformed(evt);
            }
        });

        fd.setText("Click Me!");
        fd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fdActionPerformed(evt);
            }
        });

        fe.setText("Click Me!");
        fe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feActionPerformed(evt);
            }
        });

        ff.setText("Click Me!");
        ff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffActionPerformed(evt);
            }
        });

        fg.setText("Click Me!");
        fg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fgActionPerformed(evt);
            }
        });

        fh.setText("Click Me!");
        fh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fhActionPerformed(evt);
            }
        });

        ga.setText("Click Me!");
        ga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaActionPerformed(evt);
            }
        });

        gb.setText("Click Me!");
        gb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbActionPerformed(evt);
            }
        });

        gc.setText("Click Me!");
        gc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcActionPerformed(evt);
            }
        });

        gd.setText("Click Me!");
        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });

        ge.setText("Click Me!");
        ge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geActionPerformed(evt);
            }
        });

        gf.setText("Click Me!");
        gf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gfActionPerformed(evt);
            }
        });

        gg.setText("Click Me!");
        gg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ggActionPerformed(evt);
            }
        });

        gh.setText("Click Me!");
        gh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ghActionPerformed(evt);
            }
        });

        ha.setText("Click Me!");
        ha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haActionPerformed(evt);
            }
        });

        hb.setText("Click Me!");
        hb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hbActionPerformed(evt);
            }
        });

        hc.setText("Click Me!");
        hc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcActionPerformed(evt);
            }
        });

        hd.setText("Click Me!");
        hd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdActionPerformed(evt);
            }
        });

        he.setText("Click Me!");
        he.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heActionPerformed(evt);
            }
        });

        hf.setText("Click Me!");
        hf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hfActionPerformed(evt);
            }
        });

        hg.setText("Click Me!");
        hg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hgActionPerformed(evt);
            }
        });

        hh.setText("Click Me!");
        hh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hhActionPerformed(evt);
            }
        });

        jLabel1.setText("Lives: ");

        jLabel2.setText("jLabel2");

        jLabel3.setText("Score!:");

        jLabel4.setText("jLabel4");

        jLabel5.setText("BOOM!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ce, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ba, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(be, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ab, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ae, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(af, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ag, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(da, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ea, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ef, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ge, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(he, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ab, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ac, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ae, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(af, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ag, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ba, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(be, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ce, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(da, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ea, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ef, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ge, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(he, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(1, true), true);
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        aa.setEnabled(false);
    }//GEN-LAST:event_aaActionPerformed

    private void abActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abActionPerformed
   mvcMessaging.notify("view:buttonclick", createPayload(2, true), true);
   JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ab.setEnabled(false);
    }//GEN-LAST:event_abActionPerformed

    private void acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acActionPerformed
      mvcMessaging.notify("view:buttonclick", createPayload(3, true), true);
      JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ac.setEnabled(false);
    }//GEN-LAST:event_acActionPerformed

    private void adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(4, true), true);
      JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ad.setEnabled(false);
    }//GEN-LAST:event_adActionPerformed

    private void aeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aeActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(5, true), true);
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ae.setEnabled(false);
    }//GEN-LAST:event_aeActionPerformed

    private void afActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(6, true), true);
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        af.setEnabled(false);
    }//GEN-LAST:event_afActionPerformed

    private void agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(7, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ag.setEnabled(false);
    }//GEN-LAST:event_agActionPerformed

    private void ahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ahActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(8, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ah.setEnabled(false);
    }//GEN-LAST:event_ahActionPerformed

    private void baActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(9, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ba.setEnabled(false);
    }//GEN-LAST:event_baActionPerformed

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(10, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        bb.setEnabled(false);
    }//GEN-LAST:event_bbActionPerformed

    private void bcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(11, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
    bc.setEnabled(false);
        Point foundIt = findButton(thisWasClicked);
    }//GEN-LAST:event_bcActionPerformed

    private void bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(12, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        bd.setEnabled(false);
    }//GEN-LAST:event_bdActionPerformed

    private void beActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(13, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        be.setEnabled(false);
    }//GEN-LAST:event_beActionPerformed

    private void bfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(14, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        bf.setEnabled(false);
    }//GEN-LAST:event_bfActionPerformed

    private void bgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(15, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        bg.setEnabled(false);
    }//GEN-LAST:event_bgActionPerformed

    private void bhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(16, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        bh.setEnabled(false);
    }//GEN-LAST:event_bhActionPerformed

    private void caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(17, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ca.setEnabled(false);
    }//GEN-LAST:event_caActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(18, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        cb.setEnabled(false);
    }//GEN-LAST:event_cbActionPerformed

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(19, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        cc.setEnabled(false);
    }//GEN-LAST:event_ccActionPerformed

    private void cdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(20, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        cd.setEnabled(false);
    }//GEN-LAST:event_cdActionPerformed

    private void ceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(21, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ce.setEnabled(false);
    }//GEN-LAST:event_ceActionPerformed

    private void cfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(22, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        cf.setEnabled(false);
    }//GEN-LAST:event_cfActionPerformed

    private void cgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(23, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        cg.setEnabled(false);
    }//GEN-LAST:event_cgActionPerformed

    private void chActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(24, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ch.setEnabled(false);
    }//GEN-LAST:event_chActionPerformed

    private void daActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(25, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        da.setEnabled(false);
    }//GEN-LAST:event_daActionPerformed

    private void dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(26, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        db.setEnabled(false);
    }//GEN-LAST:event_dbActionPerformed

    private void dcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(27, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        dc.setEnabled(false);
    }//GEN-LAST:event_dcActionPerformed

    private void ddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(28, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        dd.setEnabled(false);
    }//GEN-LAST:event_ddActionPerformed

    private void deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(29, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        de.setEnabled(false);
    }//GEN-LAST:event_deActionPerformed

    private void dfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(30, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        df.setEnabled(false);
    }//GEN-LAST:event_dfActionPerformed

    private void dgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dgActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(31, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        dg.setEnabled(false);
    }//GEN-LAST:event_dgActionPerformed

    private void dhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dhActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(32, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        dh.setEnabled(false);
    }//GEN-LAST:event_dhActionPerformed

    private void eaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eaActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(33, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ea.setEnabled(false);
    }//GEN-LAST:event_eaActionPerformed

    private void ebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(34, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        eb.setEnabled(false);
    }//GEN-LAST:event_ebActionPerformed

    private void ecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(35, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ec.setEnabled(false);
    }//GEN-LAST:event_ecActionPerformed

    private void edActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(36, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ed.setEnabled(false);
    }//GEN-LAST:event_edActionPerformed

    private void eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eeActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(37, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ee.setEnabled(false);
    }//GEN-LAST:event_eeActionPerformed

    private void efActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(38, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ef.setEnabled(false);
    }//GEN-LAST:event_efActionPerformed

    private void egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_egActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(39, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        eg.setEnabled(false);
    }//GEN-LAST:event_egActionPerformed

    private void ehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ehActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(40, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        eh.setEnabled(false);
    }//GEN-LAST:event_ehActionPerformed

    private void faActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(41, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fa.setEnabled(false);
    }//GEN-LAST:event_faActionPerformed

    private void fbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(42, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fb.setEnabled(false);
    }//GEN-LAST:event_fbActionPerformed

    private void fcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(43, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fc.setEnabled(false);
    }//GEN-LAST:event_fcActionPerformed

    private void fdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fdActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(44, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fd.setEnabled(false);
    }//GEN-LAST:event_fdActionPerformed

    private void feActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(45, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fe.setEnabled(false);
    }//GEN-LAST:event_feActionPerformed

    private void ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(46, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ff.setEnabled(false);
    }//GEN-LAST:event_ffActionPerformed

    private void fgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fgActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(47, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fg.setEnabled(false);
    }//GEN-LAST:event_fgActionPerformed

    private void fhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fhActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(48, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        fh.setEnabled(false);
    }//GEN-LAST:event_fhActionPerformed

    private void gaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(49, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ga.setEnabled(false);
    }//GEN-LAST:event_gaActionPerformed

    private void gbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(50, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gb.setEnabled(false);
    }//GEN-LAST:event_gbActionPerformed

    private void gcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(51, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gc.setEnabled(false);
    }//GEN-LAST:event_gcActionPerformed

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(52, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gd.setEnabled(false);
    }//GEN-LAST:event_gdActionPerformed

    private void geActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(53, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ge.setEnabled(false);
    }//GEN-LAST:event_geActionPerformed

    private void gfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gfActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(54, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gf.setEnabled(false);
    }//GEN-LAST:event_gfActionPerformed

    private void ggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ggActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(55, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gg.setEnabled(false);
    }//GEN-LAST:event_ggActionPerformed

    private void ghActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ghActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(56, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        gh.setEnabled(false);
    }//GEN-LAST:event_ghActionPerformed

    private void haActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(57, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        ha.setEnabled(false);
    }//GEN-LAST:event_haActionPerformed

    private void hbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hbActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(58, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hb.setEnabled(false);
    }//GEN-LAST:event_hbActionPerformed

    private void hcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(59, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hc.setEnabled(false);
    }//GEN-LAST:event_hcActionPerformed

    private void hdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hdActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(60, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hd.setEnabled(false);
    }//GEN-LAST:event_hdActionPerformed

    private void heActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(61, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        he.setEnabled(false);
    }//GEN-LAST:event_heActionPerformed

    private void hfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hfActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(62, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hf.setEnabled(false);
    }//GEN-LAST:event_hfActionPerformed

    private void hgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hgActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(63, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hg.setEnabled(false);
    }//GEN-LAST:event_hgActionPerformed

    private void hhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hhActionPerformed
    mvcMessaging.notify("view:buttonclick", createPayload(64, true), true);    // TODO add your handling code here:
    JButton thisWasClicked = (JButton)evt.getSource();
        Point foundIt = findButton(thisWasClicked);
        hh.setEnabled(false);
    }//GEN-LAST:event_hhActionPerformed

  /**
   * @param args the command line arguments
   */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aa;
    private javax.swing.JButton ab;
    private javax.swing.JButton ac;
    private javax.swing.JButton ad;
    private javax.swing.JButton ae;
    private javax.swing.JButton af;
    private javax.swing.JButton ag;
    private javax.swing.JButton ah;
    private javax.swing.JButton ba;
    private javax.swing.JButton bb;
    private javax.swing.JButton bc;
    private javax.swing.JButton bd;
    private javax.swing.JButton be;
    private javax.swing.JButton bf;
    private javax.swing.JButton bg;
    private javax.swing.JButton bh;
    private javax.swing.JButton ca;
    private javax.swing.JButton cb;
    private javax.swing.JButton cc;
    private javax.swing.JButton cd;
    private javax.swing.JButton ce;
    private javax.swing.JButton cf;
    private javax.swing.JButton cg;
    private javax.swing.JButton ch;
    private javax.swing.JButton da;
    private javax.swing.JButton db;
    private javax.swing.JButton dc;
    private javax.swing.JButton dd;
    private javax.swing.JButton de;
    private javax.swing.JButton df;
    private javax.swing.JButton dg;
    private javax.swing.JButton dh;
    private javax.swing.JButton ea;
    private javax.swing.JButton eb;
    private javax.swing.JButton ec;
    private javax.swing.JButton ed;
    private javax.swing.JButton ee;
    private javax.swing.JButton ef;
    private javax.swing.JButton eg;
    private javax.swing.JButton eh;
    private javax.swing.JButton fa;
    private javax.swing.JButton fb;
    private javax.swing.JButton fc;
    private javax.swing.JButton fd;
    private javax.swing.JButton fe;
    private javax.swing.JButton ff;
    private javax.swing.JButton fg;
    private javax.swing.JButton fh;
    private javax.swing.JButton ga;
    private javax.swing.JButton gb;
    private javax.swing.JButton gc;
    private javax.swing.JButton gd;
    private javax.swing.JButton ge;
    private javax.swing.JButton gf;
    private javax.swing.JButton gg;
    private javax.swing.JButton gh;
    private javax.swing.JButton ha;
    private javax.swing.JButton hb;
    private javax.swing.JButton hc;
    private javax.swing.JButton hd;
    private javax.swing.JButton he;
    private javax.swing.JButton hf;
    private javax.swing.JButton hg;
    private javax.swing.JButton hh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
