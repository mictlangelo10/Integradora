import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Clientes } from 'src/app/models/clientes';
import { ClienteService } from 'src/app/service/cliente.service';
import { TokenService } from 'src/app/service/token.service';
import { ClaseService } from 'src/app/service/clase.service';
import { Clase } from 'src/app/models/clase';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarClienteComponent implements OnInit {

  isAdmin: boolean=false;
  cliente!:Clientes ;
  clases:Clase[]=[];
  opcion!:String;

  constructor(private clienteService:ClienteService, private claseService:ClaseService ,private activateRoute:ActivatedRoute,private toastr: ToastrService,private router:Router,private token:TokenService) { }
  ngOnInit(){
    this.isAdmin = this.token.isAdmin();
    this.getClientes();
    this.getClases();
  }

  onUpdate():void{
    const id=this.activateRoute.snapshot.params['id'];
    this.clienteService.update(id,this.cliente).subscribe(
      data=>{
        this.toastr.success('Cliente Actualizado', 'OK', {
          timeOut: 3000});
          this.router.navigate(["/cliente/lista"])
      },
      err=>{
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000});
          this.router.navigate(["/cliente/lista"])
      }
    );
  }

  getClientes():void{
    const id=this.activateRoute.snapshot.params['id'];
    this.clienteService.detail(id).subscribe(
      data=>{
        this.cliente=data;
      },
      err=>{
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000}); 
          this.router.navigate(["/lista"]);
      }
    );
  }

  getClases():void{
    this.claseService.list().subscribe(
      data=>{
        this.clases=data;
      },
      err=>{
        this.toastr.error(err.error.mensaje,'Error',{timeOut:3000});
      }
    )
  }

  onClaseChange(event: any, opcion: String) {
    const isChecked = event.target.checked;
    if (isChecked) {
      this.cliente.nombreClase.push(opcion);
    } else {
      this.cliente.nombreClase = this.cliente.nombreClase.filter(c => c !== opcion);
    }
  }
  

}
