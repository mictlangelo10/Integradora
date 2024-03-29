import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Clase } from 'src/app/models/clase';
import { CreateUser } from 'src/app/models/create-user';
import { AuthService } from 'src/app/service/auth.service';
import { ClaseService } from 'src/app/service/clase.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-editar-clases',
  templateUrl: './editar-clases.component.html',
  styleUrls: ['./editar-clases.component.css']
})
export class EditarClasesComponent implements OnInit {
  
  // Declarando Variables
  isAdmin: boolean=false;
  clase!:Clase;
  id!:number;
  instructores:CreateUser[]=[];

 // Asignando valores al constructor
  constructor(
    private claseService:ClaseService,
    private empleadoService:AuthService,
    private toast:ToastrService, 
    private token:TokenService,
    private router:Router, 
    private activateRoute:ActivatedRoute
  ) { }

// Definiendo métodos de entrada
  ngOnInit(): void {
    this.isAdmin = this.token.isAdmin();
    this.getClases();
    this.getInstructores();
  }

  // Método para actualizar clases
  onUpdate():void{
    this.claseService.update(this.id,this.clase).subscribe(
      data=>{
        this.toast.success(data.mensaje,'OK',{timeOut:3000});
        this.router.navigate(['/clase/lista'])
      },
      err=>{
        this.toast.error(err.error.mensaje,'Error',{timeOut:3000});
      }
    );
  }

// Método conultar instructores
  getInstructores():void{
    this.empleadoService.listByRol("ROLE_INSTRUCTOR").subscribe(
      data=>{
        this.instructores=data;
      },
      err=>{
        this.toast.error(err.error.mensaje,'Error',{timeOut:3000});
      }
    )
  }

  // Método para obtener clases
  getClases(){
    this.id= this.activateRoute.snapshot.params['id'];
    this.claseService.detail(this.id).subscribe(
      data=>{
        this.clase=data;
      },
      err=>{
        this.toast.error(err.error.mensaje,'Error',{timeOut:3000});
        this.router.navigate(['/clase/lista'])
      }
    );
  }
}

// Autor: Miguel Hernández
