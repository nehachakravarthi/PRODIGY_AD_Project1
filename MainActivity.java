package com.example.firstproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAC,btnDel,btnAdd,btnSub,btnMul,btnDiv,btnEq,btnDot;
    private TextView textViewResult,textViewHistory;
    private String number = null;

    double firstNum = 0;
    double lastNum = 0;

    String status = null;
    boolean operator = false;
    DecimalFormat myformatter = new DecimalFormat("######.######");
    String history, currentResult;
    boolean dot=true;
    boolean btnEqcontrol=false;
    boolean btnACcontrol = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnAC=findViewById(R.id.btnAC);
        btnDel=findViewById(R.id.btnDel);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        btnEq=findViewById(R.id.btnEq);
        btnDot=findViewById(R.id.btnDot);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                        number=null;
                                        status=null;
                                        textViewResult.setText("0");
                                        textViewHistory.setText("");
                                        firstNum=0;
                                        lastNum=0;
                                        dot=true;
                                        btnACcontrol=true;
                                     }
                                 });

        btnDel.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (btnACcontrol)
                                          {
                                              textViewResult.setText("0");
                                          }
                                          else
                                          {
                                              number=number.substring(0,number.length()-1);
                                              if (number.length()==0)
                                              {
                                                  btnDel.setClickable(false);
                                              }
                                              else if (number.contains("."))
                                              {
                                                  dot=false;
                                              }
                                              else
                                              {
                                                  dot=true;
                                              }
                                              textViewResult.setText(number);
                                          }

                                      }
                                  });

        btnEq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (operator)
                        {
                            if (status=="addition")
                            {
                                plus();
                            }
                            else if(status=="subtraction")
                            {
                                minus();
                            }
                            else if(status=="multiplication")
                            {
                                multiply();
                            }
                            else if (status=="division")
                            {
                                divide();
                            }
                            else
                            {
                                firstNum=Double.parseDouble(textViewResult.getText().toString());
                            }
                        }
                        operator=false;
                        btnEqcontrol=true;
                    }
                                 });
        btnDot.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                            if (dot) {
                                                if (number == null) {
                                                    number = "0.";
                                                } else {
                                                    number = number + ".";
                                                }
                                            }
                                            textViewResult.setText(number);
                                            dot=false;

                                      }
                                  });

        btnAdd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                      public void onClick(View v) {
                                        history = textViewHistory.getText().toString();
                                        currentResult = textViewResult.getText().toString();
                                        textViewHistory.setText(history+currentResult+"+");

                                          if (operator) {
                                              if (status == "multiplication") {
                                                  multiply();
                                              } else if (status == "division") {
                                                  divide();
                                              } else if (status == "subtraction") {
                                                  minus();
                                              } else {
                                                  plus();
                                              }
                                          }
                                          status = "addition";
                                          operator = false;
                                          number = null;
                                      }

                                  });

        btnSub.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          history = textViewHistory.getText().toString();
                                          currentResult = textViewResult.getText().toString();
                                          textViewHistory.setText(history+currentResult+"-");

                                          if (operator) {
                                              if (status == "multiplication") {
                                                  multiply();
                                              } else if (status == "division") {
                                                  divide();
                                              } else if (status == "addition") {
                                                  plus();
                                              } else {
                                                  minus();
                                              }
                                          }
                                          status = "subtraction";
                                          operator = false;
                                          number = null;
                                      }
                                  });

        btnMul.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          history = textViewHistory.getText().toString();
                                          currentResult = textViewResult.getText().toString();
                                          textViewHistory.setText(history+currentResult+"*");

                                          if (operator) {
                                              if (status == "addition") {
                                                  plus();
                                              } else if (status == "division") {
                                                  divide();
                                              } else if (status == "subtraction") {
                                                  minus();
                                              } else {
                                                  multiply();
                                              }
                                          }
                                          status = "multiplication";
                                          operator = false;
                                          number = null;
                                      }
                                  });

        btnDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    history = textViewHistory.getText().toString();
                    currentResult = textViewResult.getText().toString();
                    textViewHistory.setText(history+currentResult+"/");


                    if (operator)
                    {
                        if(status=="multiplication")
                        {
                            multiply();
                        }
                        else if (status=="addition")
                        {
                            plus();
                        }
                        else if(status=="subtraction")
                        {
                            minus();
                        }
                        else {
                            divide();
                        }
                    }
                    status="division";
                    operator=false;
                    number=null;
                }
        });
    }
    public void numberClick(String view)
    {
        if (number==null)
        {
            number=view;
        } else if (btnEqcontrol) {
            firstNum=0;
            lastNum=0;
            number=view;
        } else
        {
            number = number+view;
        }
        textViewResult.setText(number);
        operator=true;
        btnACcontrol=false;
        btnDel.setClickable(true);
        btnEqcontrol=false;
    }

    public void plus()
                {
                    lastNum = Double.parseDouble(textViewResult.getText().toString());
                    firstNum = firstNum + lastNum;
                    textViewResult.setText(myformatter.format(firstNum));
                    dot=true;
                }
    public void minus()
                {
                    if (firstNum==0)
                    {
                        firstNum = Double.parseDouble(textViewResult.getText().toString());
                    }
                    else
                    {
                        lastNum = Double.parseDouble(textViewResult.getText().toString());
                        firstNum = firstNum - lastNum;
                    }
                    textViewResult.setText(myformatter.format(firstNum));
                    dot=true;
                }

    public void multiply()
                {
                    if(firstNum == 0)
                    {
                        firstNum=1;
                        lastNum = Double.parseDouble(textViewResult.getText().toString());
                        firstNum = firstNum*lastNum;
                    }
                    else
                    {
                        lastNum=Double.parseDouble(textViewResult.getText().toString());
                        firstNum=firstNum*lastNum;
                    }
                    textViewResult.setText(myformatter.format(firstNum));
                    dot=true;

                }
    public void divide()
                {
                    if (firstNum==0)
                    {
                        lastNum=Double.parseDouble(textViewResult.getText().toString());
                        firstNum=lastNum/1;
                    }
                    else
                    {
                        lastNum=Double.parseDouble(textViewResult.getText().toString());
                        firstNum=firstNum/lastNum;
                    }
                    textViewResult.setText(myformatter.format(firstNum));
                    dot=true;
                }

}
