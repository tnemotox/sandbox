<template>
  <div>
    <sub-form :subForm="subForm" ref="subForm" />
    <button @click="post">データ送信</button>
  </div>
</template>

<script>
  import SubForm from './SubForm'
  export default {
    name: 'app',

    components: {
      SubForm
    },

    data() {
        return {
        subForm: {
          field1: 'field1',
          field2: 'field2',
        }
      }
    },

    methods: {
      post() {
        console.log(this.subForm)
      }
    }
  }
</script>