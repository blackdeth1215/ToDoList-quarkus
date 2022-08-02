import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'', redirectTo:'/home', pathMatch:'full'},
  {path: 'home', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) }, {
    path: 'sing-in', loadChildren: () => import('./pages/aut/sing-in/sing-in.module').then(m => m.SingInModule) }, {
      path: 'sing-up', loadChildren: () => import('./pages/aut/sing-up/sing-up.module').then(m => m.SingUpModule) },
      {path:'**', redirectTo:'/home', pathMatch:'full'},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
