<template>
  <div id="app">
    <!--这个额就是组件部分，被main中的vue实例控制着-->
    <img src="./assets/apaq_logo.png">
    <br>
    <router-link to="/">回到首页</router-link>
    <router-link to="/login">登陆系统</router-link>
    <router-link to="/input123">输入系统</router-link>
    <router-link to="/Table">表单系统</router-link>
    <router-view/>
  </div>


</template>

<script>
export default {
  name: 'App',
  data(){
    return {

    }
  },
  methods:{

  }
}


</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
