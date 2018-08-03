<template>
  <div>
    <div>dataに格納したものをv-modelでバインドしているため、参照範囲はこのコンポーネント内のみ</div>
    <input v-model="form.field1" />
    <div>
      propsで渡されたものを直接v-modelでバインドしているため、参照範囲は親コンポーネントまで及ぶ
    </div>
    <input v-model="subForm.field2" />
  </div>
</template>

<script>
  export default {
    name: 'subForm',
    props: {
      subForm: Object
    },

    data() {
      return {
        form: {
          field1: '',
        }
      }
    },

    created() {
      this.form.field1 = this.subForm.field1
    }
  }
</script>