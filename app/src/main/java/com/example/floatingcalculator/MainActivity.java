package com.example.floatingcalculator;

import static androidx.core.widget.TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bac,bc,bp,bsqrt,bplus,bminus,bdiv,bmod,bequal,bdot,bbrac1,bbrac2,bsquare,del,bfact,percent,binv;
    TextView tvmain,tvsec;
    Button openbtn;
    ImageButton invisible;
    LinearLayout main;
    int sum = 0;
    boolean has_Dot;
    float[] lastEvent = null;
    float d = 0f;
    float newRot = 0f;
    private boolean isZoomAndRotate;
    private boolean isOutSide;
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;
    private PointF start = new PointF();
    private PointF mid = new PointF();
    float oldDist = 1f;
    public  int i = 1;
    LinearLayout linearLayout,linearLayoutmain;
    private float xCoOrdinate, yCoOrdinate;
    String pi = "3.14159265";

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bac = findViewById(R.id.bac);
        bc = findViewById(R.id.bc);
        bplus = findViewById(R.id.bplus);
        bminus = findViewById(R.id.bminus);
        bdiv = findViewById(R.id.bdiv);
        bmod = findViewById(R.id.bmod);
        bequal = findViewById(R.id.bequal);
        bdot = findViewById(R.id.bdot);
        bsqrt = findViewById(R.id.bsqrt);
        bfact = findViewById(R.id.bfact);
        bsquare = findViewById(R.id.bsquare);
        /*bsin = findViewById(R.id.bsin);
        bcos = findViewById(R.id.bcos);
        btan = findViewById(R.id.btan);*/
        del = findViewById(R.id.del);
        bbrac1 = findViewById(R.id.bbrac1);
        bbrac2 = findViewById(R.id.bbrac2);
        /*blog = findViewById(R.id.blog);
        bln = findViewById(R.id.bln);*/
        binv = findViewById(R.id.binv);
        percent = findViewById( R.id.percent );
        tvmain = findViewById(R.id.tvmain);
        tvsec = findViewById(R.id.tvsec);
        openbtn = findViewById( R.id.openbtn );
        main = findViewById( R.id.main );
        invisible = findViewById( R.id.invisible );

        invisible.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setVisibility( View.GONE );
            }
        } );

        openbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setVisibility( View.VISIBLE );
                main.setOnTouchListener( new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        LinearLayout View =(LinearLayout) view;
                        view.bringToFront();
                        viewTransformation(View, motionEvent);
                        return true;
                    }
                } );
                openbtn.setOnLongClickListener( new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        main.setVisibility( View.GONE );
                        return true;
                    }
                } );
            }
        } );
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b1.getText().toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b2.getText().toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b3.getText().toString());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b4.getText().toString());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b5.getText().toString());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b6.getText().toString());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b7.getText().toString());
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b8.getText().toString());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b9.getText().toString());
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                tvmain.setText(val+b0.getText().toString());
            }
        });
        percent.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvmain.getText().toString().equals("")) {
                    double amount = Double.parseDouble(tvmain.getText().toString());
                    double res = (amount / 100.0f) * 100;
                    String r = String.valueOf(""+res);
                    String val = tvmain.getText().toString();
                    tvmain.setText(r);
                    tvsec.setText(val);
                }else{
                    Toast.makeText(getApplicationContext(), "Amount cannot be empty", Toast.LENGTH_SHORT).show();

                }

            }
        } );
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                if (!val.contains("."))
                {
                    tvmain.setText(val+bdot.getText().toString());
                }
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!tvmain.getText().toString().isEmpty()){
                        String val = tvmain.getText().toString();
                        if (!val.equals(""))
                        {
                            tvmain.setText(val+bplus.getText().toString());
                        }
                    }else {
                        Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                if (!val.equals(""))
                {
                    tvmain.setText(val+bdiv.getText().toString());
                }
            }
        });
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (tvmain.getText().toString().isEmpty()){
                        Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                    }else {
                        String val = tvmain.getText().toString();
                        char last = val.charAt(val.length() -1);
                        if (last!='-')
                        {
                            tvmain.setText(val+bminus.getText().toString());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (tvmain.getText().toString().isEmpty()){
                        Toast.makeText( MainActivity.this, "can't be empty", Toast.LENGTH_SHORT ).show();
                    }else {
                        String val = tvmain.getText().toString();
                        char last = val.charAt(val.length() -1);
                        if (!val.equals(""))
                        {
                            tvmain.setText(val+bmod.getText().toString());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (tvmain.getText().toString().isEmpty()){
                        Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                    }else {
                        String val = tvmain.getText().toString();
                        double r = Math.sqrt(Double.parseDouble(val));
                        String result = String.valueOf(r);
                        tvmain.setText(result);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (tvmain.getText().toString().isEmpty()){
                        Toast.makeText( MainActivity.this, "can't be empty", Toast.LENGTH_SHORT ).show();
                    }else {
                        String val = tvmain.getText().toString();
                        String replacedString = val.replace('÷','/').replace('×', '*');
                        double result = eval(replacedString);
                        String r = String.valueOf(result);
                        tvmain.setText(r);
                        tvsec.setText(val);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        tvmain.setAutoSizeTextTypeUniformWithConfiguration(
                1, 17, 1, TypedValue.COMPLEX_UNIT_DIP);
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText("");
                tvsec.setText("");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tvmain.getText().toString();
                if (!val.equals(""))
                {
                    val = val.substring(0, val.length() - 1);
                    tvmain.setText(val);
                }
            }
        });

        bbrac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tvmain.setText(tvmain.getText()+"(");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bbrac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+")");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvmain.setText(tvmain.getText()+pi);
                tvsec.setText(del.getText());
            }
        });
        bsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (!tvmain.getText().toString().isEmpty()){
                        double d = Double.parseDouble(tvmain.getText().toString());
                        double square = d*d;
                        tvmain.setText(String.valueOf(square));
                        tvsec.setText(d+"²");
                    }
                    else{
                        Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
        bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!tvmain.getText().toString().isEmpty())
                    {
                        int val = Integer.parseInt( tvmain.getText().toString() );
                    int fact = factorial( val );
                    tvmain.setText( String.valueOf( fact ) );
                    tvsec.setText( val + "!" );
                }
                else
                {
                    Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText( MainActivity.this, e.getStackTrace().toString(), Toast.LENGTH_SHORT ).show();
                }
            }
        });
        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (tvmain.getText().toString().isEmpty()){
                        Toast.makeText( MainActivity.this, "Can't be empty", Toast.LENGTH_SHORT ).show();
                    }else {
                        tvmain.setText(tvmain.getText().toString()+"^"+"(-1)");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void viewTransformation(LinearLayout view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                xCoOrdinate = view.getX() - motionEvent.getRawX();
                yCoOrdinate = view.getY() - motionEvent.getRawY();

                start.set(motionEvent.getX(), motionEvent.getY());
                isOutSide = false;
                mode = DRAG;
                lastEvent = null;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(motionEvent);
                if (oldDist > 10f) {
                    midPoint(mid, motionEvent);
                    mode = ZOOM;
                }

                lastEvent = new float[4];
                lastEvent[0] = motionEvent.getX(0);
                lastEvent[1] = motionEvent.getX(1);
                lastEvent[2] = motionEvent.getY(0);
                lastEvent[3] = motionEvent.getY(1);
                d = rotation(motionEvent);
                break;
            case MotionEvent.ACTION_UP:
                isZoomAndRotate = false;
                if (mode == DRAG) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                }
            case MotionEvent.ACTION_OUTSIDE:
                isOutSide = true;
                mode = NONE;
                lastEvent = null;
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                lastEvent = null;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isOutSide) {
                    if (mode == DRAG) {
                        isZoomAndRotate = false;
                        view.animate().x(motionEvent.getRawX() + xCoOrdinate).y(motionEvent.getRawY() + yCoOrdinate).setDuration(0).start();
                    }
                    if (lastEvent != null) {
                        newRot = rotation(motionEvent);
                        view.setRotation((float) (view.getRotation() + (newRot - d)));
                    }
                }
                break;
        }

    }


    private float rotation(MotionEvent event) {
        double delta_x = (event.getX(0) - event.getX(1));
        double delta_y = (event.getY(0) - event.getY(1));
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (int) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }


    int factorial(int n)
    {

        // find factorial
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);

    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
