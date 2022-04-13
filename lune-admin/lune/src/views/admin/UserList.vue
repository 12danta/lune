<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>
    <el-table-column label="Registration Date" width="200">
      <template slot-scope="scope">{{ scope.row.date }}</template>
    </el-table-column>
    <el-table-column prop="nickname" label="nickname" width="120"> </el-table-column>
    <el-table-column prop="username" label="username" width="120"></el-table-column>
    <el-table-column prop="password" label="password" width="200"></el-table-column>
    <el-table-column
      prop="tag"
      label="status"
      :filters="[{ text: 'user', value: 'user' }, { text: 'admin', value: 'admin' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.user_status === 'user' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.user_status}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column   align="right">
        <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>

<script>
export default {
  data () {
    return {
      tableData: [
        {
          date: '2016-05-03',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'user'
        },
        {
          date: '2016-05-02',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'admin'
        },
        {
          date: '2016-05-04',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'user'
        },
        {
          date: '2016-05-01',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'admin'
        },
        {
          date: '2016-05-08',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'user'
        },
        {
          date: '2016-05-06',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'user'
        },
        {
          date: '2016-05-07',
          username: 'moon',
          password: '123',
          nickname: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          user_status: 'user'
        }
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    }
  }
}
</script>

<style scope>
</style>
