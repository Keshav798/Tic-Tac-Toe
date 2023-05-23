package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    //0==O
    //1==X
    int[] gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    //-1=null
    //0=O
    //1=X


    boolean game=true; //tells if game is ongoing or not

    public void tap(View view){ //onClick function
        TextView state=findViewById(R.id.textView2); //status of game
        ImageView image=(ImageView) view; //getting image when clicked
        int image_pos=Integer.parseInt(image.getTag().toString()); //getting tag to make changes in array
        if(game==true){ //only if nobody wont till now
            if(gameState[image_pos]==-1){
                if(activePlayer==0){
                    gameState[image_pos]=0; //set in array
                    image.setImageResource(R.drawable.o); //set image to O
                    activePlayer=1; //change current layer

                }
                else{
                    gameState[image_pos]=1;
                    image.setImageResource(R.drawable.x);
                    activePlayer=0;
                }
            }
            else{
                Toast.makeText(this, "Can't Place Here", Toast.LENGTH_SHORT).show(); //already filled
            }

            isWin(); //check for a winner
        }
        else{
            Toast.makeText(this, "Press Reset", Toast.LENGTH_SHORT).show(); //ig game is not ongoing means someone won means it needs to be reset
        }
    }

    public void reset(View view){
        TextView state=findViewById(R.id.textView2);
        game=true;
        int activePlayer=0;
        for(int i=0; i<9; i++){
            gameState[i]=-1;  //setting all values to null
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0); //setting all images to blank
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        state.setText("Game ongoing");
    }

    public void isWin(){
        TextView state=findViewById(R.id.textView2);
        if(gameState[0]!=-1 && gameState[0]==gameState[1] && gameState[1]==gameState[2]){
            if(gameState[0]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false; //setting game is stopped as someone won
            return;
        }
        else if(gameState[3]!=-1 && gameState[3]==gameState[4] && gameState[4]==gameState[5]){
            if(gameState[3]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return;
        }
        else if(gameState[6]!=-1 && gameState[6]==gameState[7] && gameState[7]==gameState[8]){
            if(gameState[6]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }
        else if(gameState[0]!=-1 && gameState[0]==gameState[3] && gameState[3]==gameState[6]){
            if(gameState[0]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }
        else if(gameState[1]!=-1 && gameState[1]==gameState[4] && gameState[4]==gameState[7]){
            if(gameState[1]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }
        else if(gameState[2]!=-1 && gameState[2]==gameState[5] && gameState[5]==gameState[8]){
            if(gameState[2]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }
        else if(gameState[0]!=-1 && gameState[0]==gameState[4] && gameState[4]==gameState[8]){
            if(gameState[0]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }
        else if(gameState[2]!=-1 && gameState[2]==gameState[4] && gameState[4]==gameState[6]){
            if(gameState[2]==0){
                state.setText("O wins!!");
            }
            else{
                state.setText("X wins!!");
            }
            game=false;
            return ;
        }

        return ;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}