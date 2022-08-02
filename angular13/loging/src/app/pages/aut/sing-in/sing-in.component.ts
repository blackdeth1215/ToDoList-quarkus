import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
export interface OptionsLog{
  id:String;
  lavel:String;
}
@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {
authForm!:FormGroup;

  constructor(private readonly fb:FormBuilder) { }

  ngOnInit(): void {
    this.initForm();

  }
  onSubmit(){
    console.log("save");
  }
  private initForm():void{
    this.authForm=this.fb.group({
      email:['',Validators.required],
      passw:['',Validators.required]
    })
  }

}
